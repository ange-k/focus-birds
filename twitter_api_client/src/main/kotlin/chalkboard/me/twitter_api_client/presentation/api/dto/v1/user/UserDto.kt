package chalkboard.me.twitter_api_client.presentation.api.dto.v1.user

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class UserDto(
    val id: String,
    val name: String,
    val screenName: String,
    val location: String?,
    val description: String,
    val url: String?,
    val entities: UserEntitiesDto,
    val protected: Boolean,
    val followersCount: Long,
    val friendsCount: Long,
    val listedCount: Long,
    val createdAt: String,
    val favouritesCount: Long,
    val utcOffset: Int,
    val timeZone: String?,
    val geoEnabled: Boolean,
    val verified: Boolean,
    val statusesCount: Long,
    val lang: String?,
    val contributorsEnabled: Boolean,
    val isTranslator: Boolean,
    val isTranslationEnabled: Boolean,
    val profileBackgroundColor: String,
    val ProfileBackgroundImageUrl: String?,
    val profileBackgroundImageUrlHttps: String?,
    val profileBackgroundTile: String?,
    val profileImageUrl: String?,
    val profileImageUrlHttps: String?,
    val profileBannerUrl: String?,
    val profileLinkColor: String?,
    val profileSidebarBorderColor: String?,
    val profileSidebarFillColor: String?,
    val profileTextColor: String?,
    val profileUseBackgroundImage: Boolean,
    val hasExtendedProfile: Boolean,
    val defaultProfile: Boolean,
    val defaultProfileImage: Boolean,
    val following: Boolean,
    val followRequestSent: Boolean,
    val notifications: Boolean,
    val translatorType: String?
) {
}