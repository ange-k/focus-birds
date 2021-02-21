package chalkboard.me.valueobject.domain.type.datetime

import java.time.LocalDateTime

/**
 * 日時型
 */
class DateTime private constructor(
    val localDateTime: LocalDateTime
){
    companion object {
        fun from(iso8601String: String) : DateTime {
            return DateTime(LocalDateTime.parse(iso8601String))
        }
    }
}