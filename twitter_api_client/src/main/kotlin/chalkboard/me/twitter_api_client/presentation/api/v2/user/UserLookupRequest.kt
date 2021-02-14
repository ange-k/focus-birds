package chalkboard.me.twitter_api_client.presentation.api.v2.user

import chalkboard.me.twitter_api_client.presentation.api.v2.user.lookup.Expansion
import chalkboard.me.twitter_api_client.presentation.api.v2.user.lookup.TweetField
import chalkboard.me.twitter_api_client.presentation.api.v2.user.lookup.UserField
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import java.util.stream.Collectors

/**
 * https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users-by-username-username
 */
data class UserLookupRequest(
    private val expansions : List<Expansion>,
    private val tweetFields: List<TweetField>,
    private val userFields: List<UserField>
) {
    fun queryParameter(): MultiValueMap<String, String> {
        val queryMap = LinkedMultiValueMap<String,String>()
        if(expansions.isNotEmpty())
            queryMap["expansions"] = expansions.stream().map { v -> v.query }
                .collect(Collectors.joining(","))

        if(tweetFields.isNotEmpty())
            queryMap["tweet.fields"] = tweetFields.stream().map { v -> v.query }
                .collect(Collectors.joining(","))

        if(userFields.isNotEmpty())
            queryMap["user.fields"] = userFields.stream().map { v -> v.query }
                .collect(Collectors.joining(","))

        return queryMap
    }
}