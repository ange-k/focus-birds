package chalkboard.me.twitter_api_client.infrastructure.transfer.config

import chalkboard.me.twitter_api_client.infrastructure.transfer.api.auth.OAuthConfig
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.boot.context.properties.NestedConfigurationProperty
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient
import java.util.concurrent.TimeUnit

@ConstructorBinding
@ConfigurationProperties(prefix = "twitter")
open class TwitterConfig(
    private val domain: String,
    private val bearer: String,
    @NestedConfigurationProperty
    private val auth: OAuthConfig
) {
    private val reactorClientHttpConnector: ReactorClientHttpConnector =
        ReactorClientHttpConnector(
            HttpClient.create().secure()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
                .doOnConnected { connection: Connection -> connection.addHandlerLast(ReadTimeoutHandler(5000L, TimeUnit.MILLISECONDS)) }
        )

    fun getBearerToken(): String {
        return "Bearer $bearer"
    }

    /**
     * https://developer.twitter.com/ja/docs/basics/authentication/api-reference/request_token
     */
    fun requestTokenClient(): WebClient {
        return WebClient.builder()
            .baseUrl(domain + auth.requestTokenPath)
            .clientConnector(reactorClientHttpConnector)
            .defaultHeaders { header ->
                header.set("oauth_consumer_key", auth.key)
                header.set("oauth_callback", auth.callback)
                header.set("oauth_signature_method", "HMAC-SHA1")
                header.set("oauth_timestamp", auth.getTimeStamp())
                header.set("oauth_nonce", auth.getNonce())
            }
            .build()
    }
}
