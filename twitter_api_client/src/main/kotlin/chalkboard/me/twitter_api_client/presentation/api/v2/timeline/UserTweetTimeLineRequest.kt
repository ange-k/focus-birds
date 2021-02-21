package chalkboard.me.twitter_api_client.presentation.api.v2.timeline

import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.Exclude
import chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.timeline.UserTimelineExpansion
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.*
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.FieldsQueryParameter
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQueries
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQuery
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.MaxResults
import chalkboard.me.valueobject.domain.type.datetime.DateTime
import org.springframework.util.MultiValueMap

/**
 * Version2, user timeline request.
 */
data class UserTweetTimeLineRequest(
    private val userId: String, // パスパラメータ
    private val endTime: DateTime?,
    private val excludes: List<Exclude>,
    private val userTimelineExpansions: List<UserTimelineExpansion>,
    private val maxResults: MaxResults?,
    private val mediaFields: List<MediaField>,
    private val paginationToken: String?, // responseのNextTokenに対応している
    private val placeFields: List<PlaceField>,
    private val pollFields: List<PollField>,
    private val sinceId: String?,
    private val startTime: DateTime?,
    private val tweetFields: List<TweetField>,
    private val untilId: String?,
    private val userFields: List<UserField>,
    ) {
    fun queryParam() : MultiValueMap<String, String> {
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