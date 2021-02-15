import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
  id("org.springframework.boot") version "2.4.2" apply false
  id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
  kotlin("jvm") version "1.4.21" apply false
  kotlin("plugin.spring") version "1.4.21" apply false
  kotlin("kapt") version "1.3.61" apply false
}

allprojects {
  group = "chalkboard.me"
  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "kotlin-kapt")

  the<DependencyManagementExtension>().apply {
    imports {
      mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
  }

  tasks.withType<Jar> {
    enabled = true
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }
  tasks.withType<Test> {
    useJUnitPlatform()
  }

  dependencies {
    "implementation"("com.fasterxml.jackson.module:jackson-module-kotlin")
    "implementation"("org.jetbrains.kotlin:kotlin-reflect")
    "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // other
    "compileOnly"("org.projectlombok:lombok")
    "annotationProcessor"("org.projectlombok:lombok")

    // testing
    "testImplementation"("org.springframework.boot:spring-boot-starter-test") {
      exclude("org.junit.vintage", "junit-vintage-engine")
    }
    "testImplementation"("org.springframework.boot:spring-boot-starter-test")
    "testImplementation"("org.assertj:assertj-core:3.11.1")

    "kapt"("org.springframework.boot:spring-boot-configuration-processor")
  }
}
