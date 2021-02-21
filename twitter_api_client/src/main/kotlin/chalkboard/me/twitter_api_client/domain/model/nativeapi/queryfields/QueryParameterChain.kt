package chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields

import org.springframework.util.MultiValueMap

interface QueryParameterChain {
    fun chain(query: MultiValueMap<String, String>)
}