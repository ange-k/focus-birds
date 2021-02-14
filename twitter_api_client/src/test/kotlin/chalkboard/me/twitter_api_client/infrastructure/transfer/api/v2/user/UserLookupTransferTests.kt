package chalkboard.me.twitter_api_client.infrastructure.transfer.api.v2.user

import chalkboard.me.twitter_api_client.TwitterApiClientApplication
import chalkboard.me.twitter_api_client.config.WireMockInitializer
import chalkboard.me.twitter_api_client.presentation.api.dto.v1.TweetDto
import chalkboard.me.twitter_api_client.presentation.api.v1.timeline.UserTimeLineRequest
import chalkboard.me.twitter_api_client.presentation.api.v2.user.UserLookupRequest
import chalkboard.me.twitter_api_client.presentation.api.v2.user.lookup.TweetField
import chalkboard.me.twitter_api_client.presentation.api.v2.user.lookup.UserField
import com.github.tomakehurst.wiremock.WireMockServer
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [TwitterApiClientApplication::class])
@ContextConfiguration(initializers = [WireMockInitializer::class])
@ConfigurationPropertiesScan
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UserLookupTransferTests(
    private val userConfig: UserConfig,
    private val wireMockServer: WireMockServer) {

    private var userLookupTransfer : UserLookupTransfer? = null

    @AfterEach
    fun setup() {
        this.wireMockServer.resetAll()
    }

    @Test
    fun UserTimeLineの取得() {
        userLookupTransfer = UserLookupTransfer(userConfig)
        val request : UserLookupRequest = UserLookupRequest(
            mutableListOf(),
            mutableListOf(TweetField.ID, TweetField.AUTHOR_ID, TweetField.PUBLIC_METRICS),
            mutableListOf(UserField.CREATED_AT, UserField.ID, UserField.USERNAME, UserField.PUBLIC_METRICS)
        )

        userLookupTransfer?.userLookup(request, "Me109E3_jp")
    }
}