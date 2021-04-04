package chalkboard.me.twitter_api_client.application.api.dto.v2.user

import chalkboard.me.twitter_api_client.application.api.dto.v2.user.timeline.PublicMetrics
import chalkboard.me.twitter_api_client.application.api.dto.v2.user.timeline.TweetEntities
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class UserTimelineResponse(
    val data: List<Data>,
    val includes: Includes?,
    val meta: Meta
) {
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Data(
        val publicMetrics: PublicMetrics,
        val text: String,
        val entities: TweetEntities?,
        val attachments: Attachments?,
        val createdAt: String,
        val source: String,
        val id: String
    ) {
        @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Attachments(val mediaKeys: Set<String>)
    }

    data class Includes(val media: List<Media>) {
        @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
        @JsonIgnoreProperties(ignoreUnknown = true)
        data class Media(
            val media_key: String,
            val type: String,
            val url: String
        )
    }

    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Meta(
        val oldestId: String,
        val newestId: String,
        val resultCount: Int,
        val nextToken: String
    )
}
