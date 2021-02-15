package chalkboard.me.twitter_api_client.presentation.api.v2.domain

enum class PollField(val query:String) {
    DURATION_MINUTES("duration_minutes"),
    END_DATETIME("end_datetime"),
    ID("id"),
    OPTIONS("options"),
    VOTING_STATUS("voting_status")
}