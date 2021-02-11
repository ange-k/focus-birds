package chalkboard.me.twitter_api_client.infrastructure.transfer.api.v1.timeline

import chalkboard.me.twitter_api_client.infrastructure.transfer.config.TwitterBearerTokenConfig
import io.netty.channel.ChannelOption
import io.netty.handler.timeout.ReadTimeoutHandler
import lombok.Getter
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.client.reactive.ReactorClientHttpConnector
import org.springframework.web.reactive.function.client.WebClient
import reactor.netty.Connection
import reactor.netty.http.client.HttpClient
import java.util.concurrent.TimeUnit

@Configuration
@ConfigurationProperties(prefix = "twitter-api.timeline")
class TimeLineConfig(
    val twitterBearerTokenConfig : TwitterBearerTokenConfig
) {
    lateinit var homeUri: String

    private val reactorClientHttpConnector: ReactorClientHttpConnector
        = ReactorClientHttpConnector(HttpClient.create().secure()
        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
        .doOnConnected { connection: Connection -> connection.addHandlerLast(ReadTimeoutHandler(5000L, TimeUnit.MILLISECONDS)) }
    )

    fun homeTimeLineClient(): WebClient {
        return WebClient.builder()
            .baseUrl(homeUri)
            .clientConnector(reactorClientHttpConnector)
            .defaultHeader(HttpHeaders.AUTHORIZATION, twitterBearerTokenConfig.getBearerToken())
            .build()
    }
}