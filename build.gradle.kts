import org.springframework.boot.gradle.plugin.SpringBootPlugin
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins {
  id("org.springframework.boot") version "2.4.2" apply false
  id("org.jetbrains.kotlin.jvm") version "1.4.21"
  id("org.jetbrains.kotlin.plugin.spring") version "1.4.21"
  id("org.jetbrains.kotlin.kapt") version "1.4.21"
}

allprojects {
  group = "chalkboard.me"
  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "org.jetbrains.kotlin.plugin.spring")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "kotlin-kapt")

  the<DependencyManagementExtension>().apply {
    imports {
      mavenBom(SpringBootPlugin.BOM_COORDINATES)
    }
  }

  tasks {
    compileKotlin {
      kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
      }
    }
    compileTestKotlin {
      kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
      }
    }
    test {
      useJUnitPlatform()
    }
  }

  dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // other
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // testing
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
      exclude("org.junit.vintage", "junit-vintage-engine")
    }
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:3.11.1")

    kapt("org.springframework.boot:spring-boot-configuration-processor")
  }
}
