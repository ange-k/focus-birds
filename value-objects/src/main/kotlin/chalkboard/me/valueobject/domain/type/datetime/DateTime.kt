package chalkboard.me.valueobject.domain.type.datetime

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * 日時型
 */
class DateTime private constructor(
    val localDateTime: LocalDateTime
){
    companion object {
        val fmtIso8601: DateTimeFormatter = DateTimeFormatter.ISO_INSTANT // sample: 2010-11-06T00:00:00Z
        fun from(iso8601String: String) : DateTime {
            return DateTime(LocalDateTime.parse(iso8601String))
        }
    }

    fun toStringIso8601() : String {
        return fmtIso8601.format(localDateTime)
    }
}