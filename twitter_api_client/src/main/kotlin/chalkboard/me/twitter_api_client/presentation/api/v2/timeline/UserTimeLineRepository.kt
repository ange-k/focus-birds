package chalkboard.me.twitter_api_client.presentation.api.v2.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v1.TweetDto
import reactor.core.publisher.Mono

interface UserTimeLineRepository {
    fun userTimeLine(requestTweet: UserTweetTimeLineRequest) : Mono<List<TweetDto>>
}