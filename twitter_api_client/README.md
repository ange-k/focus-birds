# api
twitter-apiを利用したnative-apiをインフラストラクチャ層で提供します。  
それを利用してほしい情報を取得するのが提供するAPIです。
## native-api
- [UserTimeLineの取得(v1)](https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-user_timeline)
- [UserTimeLineの取得(v2)](https://developer.twitter.com/en/docs/twitter-api/tweets/timelines/api-reference/get-users-id-tweets)
- [Userの取得(v2)](https://developer.twitter.com/en/docs/twitter-api/users/lookup/api-reference/get-users-by-username-username)

# test
## wiremock
TwitterAPIの型テストが主
### mappingの設定
正常系を `src/test/resources/mappings` にマッピング.