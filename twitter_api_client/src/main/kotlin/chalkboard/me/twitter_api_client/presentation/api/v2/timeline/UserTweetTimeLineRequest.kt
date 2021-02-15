package chalkboard.me.twitter_api_client.presentation.api.v2.timeline

data class UserTweetTimeLineRequest(
    val screenName: String,
    var count: Int? = null,
    var sinceId: String? = null,
    var maxId: String? = null,
    var trimUser: Boolean = false,
    var excludeReplies: Boolean = true, // true = リプライの非表示
    var includeRts: Boolean = false     // true = リツイートの削除
) {
}