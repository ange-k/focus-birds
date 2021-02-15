package chalkboard.me.twitter_api_client.infrastructure.transfer.api.user

import chalkboard.me.twitter_api_client.infrastructure.transfer.config.TwitterConfig
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient
import java.util.concurrent.TimeUnit

@Configuration
@ConfigurationProperties(prefix = "twitter-api.user")
open class UserConfig(
    val twitterConfig : TwitterConfig
) {
    lateinit var lookupPath: String

    private val reactorClientHttpConnector: ReactorClientHttpConnector
            = ReactorClientHttpConnector(
        HttpClient.create().secure()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
        .doOnConnected { connection: Connection -> connection.addHandlerLast(ReadTimeoutHandler(5000L, TimeUnit.MILLISECONDS)) }
    )

    fun userLookupClient(): WebClient {
        return WebClient.builder()
            .baseUrl(twitterConfig.domain + lookupPath)
            .clientConnector(reactorClientHttpConnector)
            .defaultHeader(HttpHeaders.AUTHORIZATION, twitterConfig.getBearerToken())
            .build()
    }
}