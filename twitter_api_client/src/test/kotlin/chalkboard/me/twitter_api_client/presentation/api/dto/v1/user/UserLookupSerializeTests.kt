package chalkboard.me.twitter_api_client.presentation.api.dto.v1.user

import chalkboard.me.twitter_api_client.presentation.api.dto.v2.user.LookUpResponse
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.fail
import org.junit.platform.commons.util.StringUtils
import java.net.URL

class UserLookupSerializeTests {
    @Test
    fun UserLookupをクラスにデシリアライズする() {
        val resource: URL? = this.javaClass.classLoader.getResource("__files/user/lookup.json")
        val json: String = resource?.readText() ?: ""

        if(StringUtils.isBlank(json)) fail("失敗")
        val mapper = ObjectMapper().registerModule(KotlinModule())

        val result: LookUpResponse = mapper.readValue(json)

        assertThat(result.data.name).isEqualTo("あしたば")

    }
}