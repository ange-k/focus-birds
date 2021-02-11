tasks.getByName<Jar>("bootJar") {
	enabled = true
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-batch")
	testImplementation("org.springframework.batch:spring-batch-test")
}