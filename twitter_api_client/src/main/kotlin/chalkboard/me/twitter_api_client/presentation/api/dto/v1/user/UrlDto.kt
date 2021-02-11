package chalkboard.me.twitter_api_client.presentation.api.dto.v1.user

import chalkboard.me.twitter_api_client.presentation.api.dto.v1.UrlDto

data class UrlDto(
    var urls: List<UrlDto>
) {
}