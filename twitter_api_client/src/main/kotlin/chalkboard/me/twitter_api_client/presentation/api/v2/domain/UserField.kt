package chalkboard.me.twitter_api_client.presentation.api.v2.domain

/**
 * TwitterAPIの定めるユーザー・オブジェクトモデル
 * https://developer.twitter.com/en/docs/twitter-api/data-dictionary/object-model/user
 */
enum class UserField(val query: String) {
    CREATED_AT("created_at"),   // ユーザーアカウントがTwitterで作成されたUTCの日付。
    DESCRIPTION("description"), // このユーザーのプロフィール説明
    ENTITIES("entities"),       // ユーザーの説明に特別な意味を持つテキストの詳細が含まれています
    ID("id"),
    LOCATION("location"),
    NAME("name"),
    PINNED_TWEET_ID("pinned_tweet_id"),
    PROFILE_IMAGE_URL("profile_image_url"),
    PROTECTED("protected"),
    PUBLIC_METRICS("public_metrics"),   // フォロワー数など公開メトリクス
    URL("url"),
    USERNAME("username"),
    VERIFIED("verified"),
    WITHHELD("withheld")
}