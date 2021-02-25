package chalkboard.me.twitter_api_client.application.api.dto.v1.user

import chalkboard.me.twitter_api_client.application.api.dto.v1.TweetDto
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.junit.platform.commons.util.StringUtils
import java.net.URL

class UserTimeLineSerializeTests {
    @Test
    fun UserTimeLineをクラスにデシリアライズする() {
        val resource: URL? = this.javaClass.classLoader.getResource("__files/timeline/user.json")
        val json: String = resource?.readText() ?: ""

        if(StringUtils.isBlank(json)) fail("失敗")
        val mapper = ObjectMapper().registerModule(KotlinModule())

        val result: List<TweetDto> = mapper.readValue(json)

        assertThat(result.size).isEqualTo(49)

    }
}
