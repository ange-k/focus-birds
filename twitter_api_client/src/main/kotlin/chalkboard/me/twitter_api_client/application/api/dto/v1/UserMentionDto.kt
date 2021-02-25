package chalkboard.me.twitter_api_client.application.api.dto.v1

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserMentionDto(
    val screenName: String,
    val name: String,
    val id: String,
    val indices: List<String>
) {
}
