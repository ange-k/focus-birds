package chalkboard.me.twitter_api_client.presentation.api.v2.domain

enum class PlaceField(val query:String) {
    CONTAINED_WITHIN("contained_within"),
    COUNTRY("country"),
    COUNTRY_CODE("country_code"),
    FULL_NAME("full_name"),
    GEO("geo"),
    ID("id"),
    NAME("name"),
    PLACE_TYPE("place_type")
}