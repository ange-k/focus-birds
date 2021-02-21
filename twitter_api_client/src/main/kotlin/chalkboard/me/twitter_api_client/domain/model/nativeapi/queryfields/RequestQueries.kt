package chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields

import org.springframework.util.MultiValueMap
import java.util.stream.Collectors

class RequestQueries<out T: EnumQueryFields>(
    private val key: String,
    private val list: List<T>
) {
    fun chain(query: MultiValueMap<String, String>) {
        if(list.isEmpty()) return

        query[key] = list.stream().map { v -> v.query }
            .collect(Collectors.joining(","))
    }
}