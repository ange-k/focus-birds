package chalkboard.me.twitter_api_client

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@EnableAutoConfiguration
@ComponentScan
class TwitterApiClientApplication

fun main(args: Array<String>) {
	runApplication<TwitterApiClientApplication>(*args)
}
