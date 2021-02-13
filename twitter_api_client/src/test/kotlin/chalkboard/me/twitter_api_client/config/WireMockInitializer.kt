package chalkboard.me.twitter_api_client.config

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer
import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ApplicationEvent
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.event.ContextClosedEvent

class WireMockInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
    override fun initialize(configurableApplicationContext: ConfigurableApplicationContext) {
        val wireMockServer = WireMockServer(
            WireMockConfiguration()
                .port(8088)
                .extensions(ResponseTemplateTransformer(true))
        ) // レスポンステンプレートの有効化
        wireMockServer.start()
        configurableApplicationContext.beanFactory.registerSingleton("wireMockServer", wireMockServer)
        configurableApplicationContext.addApplicationListener { applicationEvent: ApplicationEvent? ->
            if (applicationEvent is ContextClosedEvent) {
                wireMockServer.stop()
            }
        }
    }
}