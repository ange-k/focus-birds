package chalkboard.me.twitter_api_client.application.api.dto.v2.user

import chalkboard.me.twitter_api_client.application.api.dto.v2.user.lookup.PublicMetrics
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

data class LookUpResponse(val data: Data) {
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Data(
        val username: String,
        val name: String,
        val publicMetrics: PublicMetrics,
        val id: Long,
        val createdAt: String
    ) {
    }
}
