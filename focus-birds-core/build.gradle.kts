apply(plugin ="org.springframework.boot")

tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
	mainClass.set("chalkboard.me.focusbirdscore.FocusBirdsCoreApplicationKt")
}

dependencies {
	implementation(project(":twitter_api_client"))
	implementation("org.springframework.boot:spring-boot-starter-batch")
	testImplementation("org.springframework.batch:spring-batch-test")
}
