plugins {
    jacoco
}

dependencies {
    implementation(project(":value-objects"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.github.tomakehurst:wiremock:2.27.2")
}

jacoco {
    toolVersion = "0.8.6"
}

tasks.named<JacocoReport>("jacocoTestReport") {
    reports {
        xml.isEnabled = true
        html.isEnabled = true
    }
}
