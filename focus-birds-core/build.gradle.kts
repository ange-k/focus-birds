plugins {
	application
}

dependencies {
	implementation(project(":twitter_api_client"))
	implementation("org.springframework.boot:spring-boot-starter-batch")
	testImplementation("org.springframework.batch:spring-batch-test")
}

// https://docs.gradle.org/current/userguide/application_plugin.html
application {
	mainClass.set("chalkboard.me.focusbirdscore.FocusBirdsCoreApplication")
}