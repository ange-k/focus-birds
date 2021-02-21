package chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.user

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.EnumQueryFields

enum class UserLookupExpansion(override val query: String) : EnumQueryFields {
    PINNED_TWEET_ID("pinned_tweet_id")
}