package chalkboard.me.twitter_api_client.presentation.api.v2.user.lookup

enum class TweetField(val query: String) {
    ATTACHMENTS("attachments"), // ツイートに存在する添付ファイルの種類を指定
    AUTHOR_ID("author_id"), // このツイートを投稿したユーザーの固有の識別子
    CONTEXT_ANNOTATIONS("context_annotations"), // ツイートのコンテキストアノテーション
    CONVERSATION_ID("conversation_id"), // 会話の元となったTweetのID（直接の返信、リプライのリプライを含む）
    CREATED_AT("created_at"),
    ENTITIES("entities"), // ツイートのテキストから解析されたエンティティ
    GEO("geo"),
    ID("id"),
    IN_REPLY_TO_USER_ID("in_reply_to_user_id"), // 表記されたツイートが返信である場合、このフィールドには元のツイートの作者IDが含まれます。
                                                      // これは必ずしもツイートで直接言及されたユーザーとは限りません
    LANG("lang"),
    NON_PUBLIC_METRICS("non_public_metrics"), //リクエスト時のツイートの非公開エンゲージメントメトリクス ※ ユーザ認証必要
    PUBLIC_METRICS("public_metrics"), // リツイート数など公開されているメトリクス
    ORGANIC_METRICS("organic_metrics"), // ※ ユーザ認証必要
    PROMOTED_METRICS("promoted_metrics"), // ※ ユーザ認証必要
    POSSIBLY_SENSITIVE("possibly_sensitive"), // センシティブ判定結果
    REFERENCED_TWEETS("referenced_tweets"), //このツイートが参照しているツイートのリスト
    SOURCE("source"),
    TEXT("text"),
    WITHHELD("withheld")
}