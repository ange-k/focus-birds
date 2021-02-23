package chalkboard.me.twitter_api_client.infrastructure.transfer.api.user

import chalkboard.me.twitter_api_client.ComponentTestConfig
import chalkboard.me.twitter_api_client.config.WireMockInitializer
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQueries
import chalkboard.me.twitter_api_client.infrastructure.transfer.config.TwitterConfig
import chalkboard.me.twitter_api_client.presentation.api.dto.v2.user.LookUpResponse
import chalkboard.me.twitter_api_client.presentation.api.v2.user.UserLookupRequest
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.TweetField
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.UserField
import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@ExtendWith(SpringExtension::class)
@SpringBootTest(classes = [ComponentTestConfig::class])
@ContextConfiguration(initializers = [WireMockInitializer::class])
@EnableConfigurationProperties(TwitterConfig::class)
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
    fun UserLookupの取得() {
        // setup
        val id = "Me109E3_jp"
        userLookupTransfer = UserLookupTransfer(userConfig)
        val request : UserLookupRequest = UserLookupRequest(
            RequestQueries("expansions", mutableListOf()),
            RequestQueries("tweet.fields", mutableListOf(TweetField.ID, TweetField.AUTHOR_ID, TweetField.PUBLIC_METRICS)),
            RequestQueries("user.fields",mutableListOf(UserField.CREATED_AT, UserField.ID, UserField.USERNAME, UserField.PUBLIC_METRICS))
        )
        val responseMono: Mono<LookUpResponse>? = userLookupTransfer?.userLookup(request, id)

        // verify
        responseMono?.also {
            StepVerifier.create(it)
                .expectNextMatches { response ->
                    response.data.name == "あしたば"
                }.verifyComplete()
        } ?: run {
            fail("テスト失敗")
        }
        wireMockServer.verify(
            getRequestedFor(urlPathEqualTo("/2/users/by/username/$id"))
                .withQueryParam("tweet.fields", equalTo("id,author_id,public_metrics"))
                .withQueryParam("user.fields", equalTo("created_at,id,username,public_metrics"))
        )
    }
}