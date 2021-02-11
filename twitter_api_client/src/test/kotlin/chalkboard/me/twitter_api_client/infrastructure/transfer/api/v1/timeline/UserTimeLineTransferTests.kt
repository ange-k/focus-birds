package chalkboard.me.twitter_api_client.infrastructure.transfer.api.v1.timeline

import chalkboard.me.twitter_api_client.presentation.api.dto.v1.TweetDto
import chalkboard.me.twitter_api_client.presentation.api.v1.timeline.UserTimeLineRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.fail
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.junit.jupiter.SpringExtension
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@ExtendWith(SpringExtension::class)
@SpringBootTest
@ConfigurationPropertiesScan
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class UserTimeLineTransferTests(val timeLineConfig : TimeLineConfig) {
    private var userTimeLineTransfer : UserTimeLineTransfer? = null

    @Test
    fun UserTimeLineの取得() {
        userTimeLineTransfer = UserTimeLineTransfer(timeLineConfig)
        val requert : UserTimeLineRequest = UserTimeLineRequest("Me109E3_jp").also {
            it.count = 50
        }

        val responseMono: Mono<List<TweetDto>>? = userTimeLineTransfer?.userTimeLine(requert)
        responseMono?.also {
            StepVerifier.create(it)
                .expectNextMatches { response ->
                    response.size == 49
                }
        } ?: run {
            fail("テスト失敗")
        }
    }
}