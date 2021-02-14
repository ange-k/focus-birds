package chalkboard.me.twitter_api_client.infrastructure.transfer.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration

@ConstructorBinding
@ConfigurationProperties(prefix="twitter")
open class TwitterConfig(
    val domain: String,
    val bearer: String
) {
    fun getBearerToken(): String {
        return "Bearer $bearer"
    }
}