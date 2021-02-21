package chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields

import org.springframework.util.MultiValueMap
import java.util.stream.Collectors

class RequestQuery (
    private val key: String,
    private val value: String
) : QueryParameterChain {
    override fun chain(query: MultiValueMap<String, String>) {
        query[key] = value
    }
}