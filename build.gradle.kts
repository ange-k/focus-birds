plugins {
  id("org.springframework.boot") version "2.4.2"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
  kotlin("jvm") version "1.4.21"
  kotlin("plugin.spring") version "1.4.21"
  kotlin("kapt") version "1.3.61"
}

group = "chalkboard.me"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

allprojects {
  tasks.register("hello") {
    doLast {
      println("I'm ${this.project.name}")
    }
  }
  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-kapt")
  apply(plugin = "org.jetbrains.kotlin.jvm")
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")

  dependencyManagement {
    imports {
      mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
  }

  configurations {
    compileOnly {
      extendsFrom(configurations.annotationProcessor.get())
    }
  }

  tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }
  tasks.withType<Test> {
    useJUnitPlatform()
  }
  dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // other
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
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