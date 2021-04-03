package chalkboard.me.twitter_api_client.application.api.dto.v2.user.timeline

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
data class Url(
    val url: String,
    val expandedUrl: String,
    val images: List<Image>?,
    val title: String?,
    val description: String?,
    val unwoundUrl: String?
) {
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Image(
        val url: String
    )
}
