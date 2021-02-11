package chalkboard.me.twitter_api_client.presentation.api.v1.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v1.TweetDto
import reactor.core.publisher.Mono

interface UserTimeLineRepository {
    fun userTimeLine(request: UserTimeLineRequest) : Mono<List<TweetDto>>
}