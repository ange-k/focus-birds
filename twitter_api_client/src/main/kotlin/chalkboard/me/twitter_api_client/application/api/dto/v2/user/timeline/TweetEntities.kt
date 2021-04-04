package chalkboard.me.twitter_api_client.application.api.dto.v2.user.timeline

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class TweetEntities(
    val hashtags: List<HashTag>?,
    val urls: List<Url>?,
    val mentions: List<Mention>?
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class HashTag(
        val tag: String
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Mention(
        val username: String
    )
}
