package chalkboard.me.focusbirdscore

import org.springframework.boot.WebApplicationType
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.ConfigurationPropertiesScan

@SpringBootApplication
@ConfigurationPropertiesScan
class FocusBirdsCoreApplication

fun main(args: Array<String>) {
    SpringApplicationBuilder()
        .sources(FocusBirdsCoreApplication::class.java)
        .web(WebApplicationType.NONE)
        .run(*args)
}
