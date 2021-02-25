package chalkboard.me.twitter_api_client.application.api.v1.timeline

/**
 * https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-user_timeline
 */
data class UserTimeLineRequest(
    val screenName: String,
    var count: Int? = null,
    var sinceId: String? = null,
    var maxId: String? = null,
    var trimUser: Boolean = false,
    var excludeReplies: Boolean = true, // true = リプライの非表示
    var includeRts: Boolean = false     // true = リツイートの削除
) {
}
