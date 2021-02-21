package chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields

import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

class FieldsQueryParameter private constructor(
    val queryMap: MultiValueMap<String,String>
) {
    companion object {
        fun from(vararg  requests: QueryParameterChain) : FieldsQueryParameter {
            val queryMap: MultiValueMap<String,String> = LinkedMultiValueMap()
            requests.forEach { req -> req.chain(queryMap) }
            return FieldsQueryParameter(queryMap)
        }
    }
}