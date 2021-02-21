package chalkboard.me.twitter_api_client.domain.model.nativeapi.fields

import chalkboard.me.twitter_api_client.domain.model.nativeapi.queryfields.EnumQueryFields

enum class PlaceField(override val query:String) : EnumQueryFields {
    CONTAINED_WITHIN("contained_within"),
    COUNTRY("country"),
    COUNTRY_CODE("country_code"),
    FULL_NAME("full_name"),
    GEO("geo"),
    ID("id"),
    NAME("name"),
    PLACE_TYPE("place_type")
}