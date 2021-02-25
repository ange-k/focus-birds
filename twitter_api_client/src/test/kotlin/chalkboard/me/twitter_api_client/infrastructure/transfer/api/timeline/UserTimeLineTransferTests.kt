package chalkboard.me.twitter_api_client.infrastructure.transfer.api.timeline

import chalkboard.me.twitter_api_client.ComponentTestConfig
import chalkboard.me.twitter_api_client.config.WireMockInitializer
import chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.timeline.UserTimelineExpansion
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.MediaField
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.TweetField
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.Exclude
import chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline.MaxResults
import chalkboard.me.twitter_api_client.infrastructure.transfer.config.TwitterConfig
import chalkboard.me.twitter_api_client.presentation.api.dto.v1.TweetDto
import chalkboard.me.twitter_api_client.presentation.api.v1.timeline.UserTimeLineRequest
import chalkboard.me.twitter_api_client.presentation.api.v2.timeline.UserTweetTimeLineRequest
import chalkboard.me.valueobject.domain.type.datetime.DateTime
import com.github.tomakehurst.wiremock.WireMockServer
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
class UserTimeLineTransferTests(
    private val timeLineConfig: TimeLineConfig,
    private val wireMockServer: WireMockServer
) {
    private var userTimeLineTransfer: UserTimeLineTransfer? = null

    @AfterEach
    fun setup() {
        this.wireMockServer.resetAll()
    }

    @Test
    fun v1UserTimeLineの取得() {
        userTimeLineTransfer = UserTimeLineTransfer(timeLineConfig)
        val request: UserTimeLineRequest = UserTimeLineRequest("Me109E3_jp").also {
            it.count = 50
        }

        val responseMono: Mono<List<TweetDto>>? = userTimeLineTransfer?.v1UserTimeLine(request)
        responseMono?.also {
            StepVerifier.create(it)
                .expectNextMatches { response ->
                    response.size == 49
                }.verifyComplete()
        } ?: run {
            fail("テスト失敗")
        }
    }

    @Test
    fun v2UserTimeLineの取得() {
        userTimeLineTransfer = UserTimeLineTransfer(timeLineConfig)
        val request: UserTweetTimeLineRequest = UserTweetTimeLineRequest("94954128").also {
            it.excludes = listOf(Exclude.REPLIES, Exclude.RETWEETS)
            it.userTimelineExpansions = listOf(UserTimelineExpansion.ATTACHMENTS_MEDIA_KEYS)
            it.maxResults = MaxResults.from(100)
            it.mediaFields = listOf(MediaField.URL, MediaField.TYPE, MediaField.PUBLIC_METRICS)
            it.tweetFields = listOf(TweetField.TEXT, TweetField.SOURCE, TweetField.PUBLIC_METRICS, TweetField.CREATED_AT, TweetField.ENTITIES)
        }

        val responseMono: Mono<String>? = userTimeLineTransfer?.v2UserTweetTimeLine(request)
        responseMono?.also {
            System.out.println(it.block())
        } ?: run {
            fail("失敗")
        }
    }
}
