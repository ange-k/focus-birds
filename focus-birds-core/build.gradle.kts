apply(plugin ="org.springframework.boot")

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	mainClass.set("chalkboard.me.focusbirdscore.FocusBirdsCoreApplicationKt")
}

dependencies {
	implementation(project(":twitter_api_client"))
	implementation("org.springframework.boot:spring-boot-starter-batch")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.3")
	runtimeOnly("mysql:mysql-connector-java")
	testImplementation("org.springframework.batch:spring-batch-test")

	testImplementation("org.testcontainers:testcontainers:1.15.2")
	testImplementation("org.testcontainers:mysql:1.15.2")
}
