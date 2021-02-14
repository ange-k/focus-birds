package chalkboard.me.twitter_api_client.infrastructure.transfer.api.v2.user

import chalkboard.me.twitter_api_client.infrastructure.transfer.api.v1.timeline.UserTimeLineTransfer
import chalkboard.me.twitter_api_client.presentation.api.v2.user.UserLookupRepository
import chalkboard.me.twitter_api_client.presentation.api.v2.user.UserLookupRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import java.lang.RuntimeException

@Repository
class UserLookupTransfer(
    private val userConfig: UserConfig
) : UserLookupRepository {

    companion object {
        private val log = LoggerFactory.getLogger(UserTimeLineTransfer::class.java)
    }

    fun userLookup(request: UserLookupRequest, screenName: String) {
        val result:String? = userConfig.userLookupClient().get()
            .uri { builder ->
                builder.queryParams(request.queryParameter()).build(screenName)
            }
            .retrieve()
            .onStatus(HttpStatus::isError) { clientResponse ->
                clientResponse.bodyToMono(String::class.java).map { response ->
                    log.error(response)
                    RuntimeException()
                }
            }
            .bodyToMono(String::class.java).block()
        log.info(result)
    }
}