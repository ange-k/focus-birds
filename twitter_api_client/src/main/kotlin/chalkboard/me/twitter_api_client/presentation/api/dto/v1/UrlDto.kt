package chalkboard.me.twitter_api_client.presentation.api.dto.v1

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UrlDto(
    val url:String,
    val expandedUrl: String,
    val displayUrl: String,
    var indices: List<String>
) {
}