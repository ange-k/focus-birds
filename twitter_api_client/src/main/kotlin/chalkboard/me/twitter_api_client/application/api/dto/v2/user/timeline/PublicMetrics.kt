package chalkboard.me.twitter_api_client.application.api.dto.v2.user.timeline

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class PublicMetrics(
    val retweetCount: Long,
    val replyCount: Long,
    val likeCount: Long,
    val quoteCount: Long
)
