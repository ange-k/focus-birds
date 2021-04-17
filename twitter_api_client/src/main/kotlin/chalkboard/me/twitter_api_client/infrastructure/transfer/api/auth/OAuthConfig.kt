package chalkboard.me.twitter_api_client.infrastructure.transfer.api.auth

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "twitter.auth")
data class OAuthConfig(
    val key: String,
    val secret: String,
    val callback: String,
    val requestTokenPath: String
) {
    fun getTimeStamp(): String {
        return (System.currentTimeMillis() / 1000).toString()
    }

    fun getNonce(): String {
        return System.currentTimeMillis().toString()
    }
}
