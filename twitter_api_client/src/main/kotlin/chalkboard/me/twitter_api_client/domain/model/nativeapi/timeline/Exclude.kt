package chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.EnumQueryFields

/**
 * レスポンスから除外するツイートの種類
 * exclude=retweetsを使用した場合、過去のツイートの最大数は3200です。
 * exclude=replies パラメータに何らかの値を指定した場合は、直近の 800 個のツイートのみが利用可能です。
 */
enum class Exclude(override val query:String) : EnumQueryFields {
    RETWEETS("retweets"),
    REPLIES("replies")
}