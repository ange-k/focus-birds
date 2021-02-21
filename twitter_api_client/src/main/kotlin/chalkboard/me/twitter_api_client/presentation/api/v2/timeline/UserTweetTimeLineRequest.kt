package chalkboard.me.twitter_api_client.presentation.api.v2.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v2.user.LookUpResponse

/**
 * Version2, user timeline request.
 */
data class UserTweetTimeLineRequest(
    private val lookUpResponse: LookUpResponse,
) {
}