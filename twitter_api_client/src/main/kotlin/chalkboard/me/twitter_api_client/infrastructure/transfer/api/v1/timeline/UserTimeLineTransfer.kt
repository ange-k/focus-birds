package chalkboard.me.twitter_api_client.infrastructure.transfer.api.v1.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v1.TweetDto
import chalkboard.me.twitter_api_client.presentation.api.v1.timeline.UserTimeLineRepository
import chalkboard.me.twitter_api_client.presentation.api.v1.timeline.UserTimeLineRequest
import org.slf4j.LoggerFactory
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.lang.RuntimeException

@Repository
class UserTimeLineTransfer(
    private val timeLineConfig: TimeLineConfig) : UserTimeLineRepository {

    companion object {
        private val log = LoggerFactory.getLogger(UserTimeLineTransfer::class.java)
    }

    override fun userTimeLine(request: UserTimeLineRequest) : Mono<List<TweetDto>> {
        return timeLineConfig.v1UserTimeLineClient().get()
            .uri { builder ->
                builder.queryParam("screen_name", request.screenName)
                request.count?.let { builder.queryParam("count", request.count) }
                request.maxId?.let { builder.queryParam("max_id", request.maxId) }
                request.sinceId?.let { builder.queryParam("since_id", request.sinceId) }
                builder.queryParam("exclide_replies", request.excludeReplies.toString())
                builder.queryParam("include_rts",request.includeRts)
                builder.queryParam("trim_user", request.trimUser).build()
            }
            .retrieve()
            .onStatus(HttpStatus::isError) { clientResponse ->
                clientResponse.bodyToMono(String::class.java).map { response ->
                    log.error(response)
                    RuntimeException()
                }
            }
            .bodyToMono(object: ParameterizedTypeReference<List<TweetDto>>(){})
    }
}