package chalkboard.me.twitter_api_client.domain.model.nativeapi.expansions.timeline

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.EnumQueryFields

enum class UserTimelineExpansion(override val query: String) : EnumQueryFields {
    ATTACHMENTS_POLL_IDS("attachments.poll_ids"), // Tweetに含まれるポーリングのメタデータを含むポーリングオブジェクトを返す
    ATTACHMENTS_MEDIA_KEYS("attachments.media_keys"), // ツイートに含まれる画像、動画、GIFを表すメディアオブジェクトを返す
    AUTHOR_ID("author_id"), // 作成者のIDを返す
    ENTITIES_MENTIONS_USERNAME("entities.mentions.username"), // Tweetに記載されているユーザーのユーザーオブジェクトを返す
    GEO_PLACE_ID("geo.place_id"), // ツイートでタグ付けされた場所のメタデータを含む場所オブジェクトを返す
    IN_REPLY_TO_USER_ID("in_reply_to_user_id"), // この要求されたツイートの返信先であるツイート作成者を表すユーザーオブジェクトを返す
    REFERENCED_TWEETS_ID("referenced_tweets.id"), // このツイートが参照しているTweetオブジェクトを返します
    REFERENCED_TWEETS_ID_AUTHOR_ID("referenced_tweets.id.author_id")
}
