package chalkboard.me.twitter_api_client.application.api.v2.timeline

import chalkboard.me.twitter_api_client.application.api.dto.v1.TweetDto
import reactor.core.publisher.Mono

interface UserTimeLineRepository {
    fun userTimeLine(requestTweet: UserTweetTimeLineRequest) : Mono<List<TweetDto>>
}
