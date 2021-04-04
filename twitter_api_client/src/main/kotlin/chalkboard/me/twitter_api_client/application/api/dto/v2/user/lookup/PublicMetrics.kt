package chalkboard.me.twitter_api_client.application.api.dto.v2.user.lookup

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class PublicMetrics(
    val followersCount: Long,
    val followingCount: Long,
    val tweetCount: Long,
    val listedCount: Int
)
