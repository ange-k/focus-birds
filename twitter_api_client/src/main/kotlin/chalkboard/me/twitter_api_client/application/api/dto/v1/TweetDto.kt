package chalkboard.me.twitter_api_client.application.api.dto.v1

import chalkboard.me.twitter_api_client.application.api.dto.v1.user.UserDto
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class TweetDto (
    val createdAt: String,
    val id: String,
    val text: String,
    val truncated: Boolean,
    val entities: TweetEntitiesDto,
    val source: String?,
    var inReplyToStatusId: String?,
    var inReplyToUserId: String?,
    var inReplyToScreenName: String?,
    val user: UserDto,
    var geo: String?,
    var coordinates: String?,
    var place: String?,
    var contributors: String?,
//    var retweeted_status
    val isQuoteStatus: Boolean,
    var retweetCount: Long,
    var favoriteCount: Long,
    val favorited: Boolean,
    val retweeted: Boolean,
    val possiblySensitive: Boolean,
    val lang: String?
    ) {
}
