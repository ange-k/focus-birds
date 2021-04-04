package chalkboard.me.twitter_api_client.application.api.v2.timeline

import chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.timeline.UserTimelineExpansion
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.* // ktlint-disable no-wildcard-imports
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.FieldsQueryParameter
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQueries
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQuery
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.Exclude
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.MaxResults
import chalkboard.me.valueobject.domain.type.datetime.DateTime
import org.springframework.util.MultiValueMap

/**
 * Version2, user timeline request.
 */
data class UserTweetTimeLineRequest(
    val userId: String, // パスパラメータ
    var endTime: DateTime? = null, // 最新のUTCタイムスタンプ
    var excludes: List<Exclude> = emptyList(), // レスポンスから除外するもの
    var userTimelineExpansions: List<UserTimelineExpansion> = emptyList(), // 追加で要求するデータ
    var maxResults: MaxResults? = null, // 最大件数
    var mediaFields: List<MediaField> = emptyList(), // メディアフィールドの追加
    var paginationToken: String? = null, // responseのNextTokenに対応している
    var placeFields: List<PlaceField> = emptyList(),
    var pollFields: List<PollField> = emptyList(),
    var sinceId: String? = null,
    var startTime: DateTime? = null,
    var tweetFields: List<TweetField> = emptyList(),
    var untilId: String? = null,
    var userFields: List<UserField> = emptyList(),
) {
    fun queryParam(): MultiValueMap<String, String> {
        return FieldsQueryParameter.from(
            RequestQuery("end_time", endTime?.toStringIso8601()),
            RequestQueries("exclude", excludes),
            RequestQueries("expansions", userTimelineExpansions),
            RequestQuery("max_results", maxResults?.value.toString()),
            RequestQueries("media.fields", mediaFields),
            RequestQuery("pagination_token", paginationToken),
            RequestQueries("place.fields", placeFields),
            RequestQueries("poll.fields", pollFields),
            RequestQuery("since_id", sinceId),
            RequestQuery("start_time", startTime?.toStringIso8601()),
            RequestQueries("tweet.fields", tweetFields),
            RequestQuery("untilId", untilId),
            RequestQueries("user.fields", userFields)
        ).queryMap
    }
}
