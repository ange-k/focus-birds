package chalkboard.me.twitter_api_client.application.api.v2.timeline

import chalkboard.me.twitter_api_client.application.api.dto.v2.user.UserTimelineResponse
import reactor.core.publisher.Mono

interface UserTweetTimeLineRepository {
    fun v2UserTweetTimeLine(requestTweet: UserTweetTimeLineRequest): Mono<UserTimelineResponse>
}
