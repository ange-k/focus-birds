package chalkboard.me.twitter_api_client.application.api.v2.user

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.FieldsQueryParameter
import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.RequestQueries
import chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.user.UserLookupExpansion
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.TweetField
import chalkboard.me.twitter_api_client.domain.model.nativeapi.fields.UserField
import org.springframework.util.MultiValueMap

/**
 * https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users-by-username-username
 */
data class UserLookupRequest(
    private val userLookupExpansions : RequestQueries<UserLookupExpansion>,
    private val tweetFields: RequestQueries<TweetField>,
    private val userFields: RequestQueries<UserField>
) {
    fun queryParameter(): MultiValueMap<String, String> {
        return FieldsQueryParameter.from(
            userLookupExpansions, tweetFields, userFields).queryMap
    }
}
