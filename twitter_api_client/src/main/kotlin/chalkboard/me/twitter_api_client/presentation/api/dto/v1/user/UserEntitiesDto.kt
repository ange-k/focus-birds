package chalkboard.me.twitter_api_client.presentation.api.dto.v1.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
class UserEntitiesDto(
    val url: UrlDto?,
    val description: DescriptionDto
) {
}