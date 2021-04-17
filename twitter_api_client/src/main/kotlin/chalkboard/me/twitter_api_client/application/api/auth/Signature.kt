package chalkboard.me.twitter_api_client.application.api.auth

import chalkboard.me.twitter_api_client.infrastructure.transfer.api.auth.OAuthConfig
import org.apache.commons.codec.binary.Hex
import org.yaml.snakeyaml.util.UriEncoder
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class Signature(
    val domain: String,
    val auth: OAuthConfig,
    val unixtime: Long
) {
    private val header: String

    init {
        val requestMap: MutableMap<String, String> = mutableMapOf(
            "oauth_consumer_key" to auth.key,
            "oauth_callback" to auth.callback,
            "oauth_signature_method" to "HMAC-SHA1",
            "oauth_timestamp" to (unixtime / 1000).toString(),
            "oauth_nonce" to unixtime.toString()
        )
        val requestParams = requestMap.map { (k, v) ->
            val encodeValue = UriEncoder.encode(v)
            "$k=$encodeValue"
        }.joinToString(separator = "&")

        val dataOfSign = UriEncoder.encode("POST") + "&" + UriEncoder.encode(domain + auth.requestTokenPath)
        val keyOfSign = UriEncoder.encode(auth.secret) + "&"

        val sk = SecretKeySpec(keyOfSign.toByteArray(), "HmacSHA1")
        val mac: Mac = Mac.getInstance("HmacSHA1")
        mac.init(sk)
        mac.update(dataOfSign.toByteArray())

        val signature = String(Hex.encodeHex(mac.doFinal()))

        requestMap["oauth_signature"] = UriEncoder.encode(signature)

        header = "Authorization: OAuth " + requestMap.map { (k, v) ->
            "$k=$v"
        }.joinToString(",")
    }
}
