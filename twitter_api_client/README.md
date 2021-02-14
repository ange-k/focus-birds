# api
twitter-apiを利用したnative-apiをインフラストラクチャ層で提供します。  
それを利用してほしい情報を取得するのが提供するAPIです。
## native-api
- [UserTimeLineの取得](https://developer.twitter.com/en/docs/twitter-api/v1/tweets/timelines/api-reference/get-statuses-user_timeline)
- []

# test
## wiremock
TwitterAPIの型テストが主
### mappingの設定
正常系を `src/test/resources/mappings` にマッピング.