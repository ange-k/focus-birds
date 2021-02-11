package chalkboard.me.twitter_api_client.infrastructure.transfer.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix="twitter")
class TwitterBearerTokenConfig {
    lateinit var bearer: String

    fun getBearerToken(): String {
        return "Bearer $bearer"
    }
}