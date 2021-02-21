package chalkboard.me.twitter_api_client.domain.model.nativeapi.timeline

import java.lang.RuntimeException

class MaxResults private constructor(
    val value: Int
) {
    companion object{
        const val MIN = 5
        const val MAX = 100

        fun from(value: Int): MaxResults {
            if(value < MIN) throw RuntimeException("最小値を下回った")
            if(value > MAX) throw RuntimeException("最大値を上回った")
            return MaxResults(value)
        }
    }
}