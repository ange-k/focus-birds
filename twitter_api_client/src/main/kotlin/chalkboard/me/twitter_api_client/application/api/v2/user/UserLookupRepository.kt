package chalkboard.me.twitter_api_client.application.api.v2.user

import chalkboard.me.twitter_api_client.application.api.dto.v2.user.LookUpResponse
import reactor.core.publisher.Mono

interface UserLookupRepository {
    fun userLookup(request: UserLookupRequest, screenName: String): Mono<LookUpResponse>
}
