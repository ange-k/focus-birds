package chalkboard.me.twitter_api_client.domain.model.nativeapi.fields

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.EnumQueryFields

enum class PollField(override val query:String) : EnumQueryFields {
    DURATION_MINUTES("duration_minutes"),
    END_DATETIME("end_datetime"),
    ID("id"),
    OPTIONS("options"),
    VOTING_STATUS("voting_status")
}