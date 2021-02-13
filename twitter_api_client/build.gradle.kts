tasks.getByName<Jar>("jar") {
    enabled = true
}
tasks.getByName<Jar>("bootJar") {
    enabled = false
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("com.github.tomakehurst:wiremock:2.27.2")
}