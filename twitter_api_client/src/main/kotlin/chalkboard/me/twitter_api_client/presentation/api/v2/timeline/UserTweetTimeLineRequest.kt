package chalkboard.me.twitter_api_client.presentation.api.v2.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v2.user.LookUpResponse
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.Exclude
import chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.timeline.UserTimelineExpansion
import chalkboard.me.valueobject.domain.type.datetime.DateTime

/**
 * Version2, user timeline request.
 */
data class UserTweetTimeLineRequest(
    private val lookUpResponse: LookUpResponse,
    private var endTime: DateTime,
    private var excludes: List<Exclude>,
    private var userTimelineExpansions: List<UserTimelineExpansion>,


    ) {
}