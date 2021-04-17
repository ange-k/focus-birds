package chalkboard.me.twitter_api_client.infrastructure.transfer.api.auth

import chalkboard.me.twitter_api_client.application.api.auth.OAuthApi
import org.springframework.stereotype.Repository

@Repository
class OAuthTransfer(
    private val config: OAuthConfig
) : OAuthApi {
    override fun getRequestToken() {
        TODO("Not yet implemented")
    }
}
