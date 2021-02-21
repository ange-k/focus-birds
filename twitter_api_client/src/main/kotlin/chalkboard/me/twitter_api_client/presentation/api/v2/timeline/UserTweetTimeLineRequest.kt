package chalkboard.me.twitter_api_client.presentation.api.v2.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v2.user.LookUpResponse
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.Exclude
import chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.timeline.UserTimelineExpansion
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.*
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQueries
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.MaxResults
import chalkboard.me.valueobject.domain.type.datetime.DateTime

/**
 * Version2, user timeline request.
 */
data class UserTweetTimeLineRequest(
    private val lookUpResponse: LookUpResponse,
    private var endTime: DateTime,
    private var excludes: RequestQueries<Exclude>,
    private var userTimelineExpansions: RequestQueries<UserTimelineExpansion>,
    private var maxResults: MaxResults,
    private var mediaFields: RequestQueries<MediaField>,
    private var paginationToken: String, // responseのNextTokenに対応している
    private var placeFields: RequestQueries<PlaceField>,
    private var pollFields: RequestQueries<PollField>,
    private var sinceId: String,
    private var startTime: DateTime,
    private var tweetFields: RequestQueries<TweetField>,
    private var untilId: String,
    private var userFields: RequestQueries<UserField>,
    ) {
}