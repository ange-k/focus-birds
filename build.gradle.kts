import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.tasks.testing.logging.* // ktlint-disable no-wildcard-imports
import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") version "2.4.2" apply false
    id("org.jetbrains.kotlin.jvm") version "1.4.21"
    id("org.jetbrains.kotlin.plugin.spring") version "1.4.21"
    id("org.jetbrains.kotlin.kapt") version "1.4.21"
    jacoco
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
            dependsOn(processResources)
        }
        compileTestKotlin {
            kotlinOptions {
                freeCompilerArgs = listOf("-Xjsr305=strict")
                jvmTarget = "11"
            }
        }
        test {
            useJUnitPlatform()
            testLogging {
                showStandardStreams = false
                showCauses = true
                exceptionFormat = TestExceptionFormat.FULL
                events(
                    TestLogEvent.PASSED,
                    TestLogEvent.FAILED,
                    TestLogEvent.SKIPPED
                )
            }
        }
    }

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

        // testing
        testImplementation("org.springframework.boot:spring-boot-starter-test") {
            exclude("org.junit.vintage", "junit-vintage-engine")
        }
        testImplementation("org.assertj:assertj-core:3.11.1")

        kapt("org.springframework.boot", "spring-boot-configuration-processor", "2.4.2")
        compileOnly("org.springframework.boot:spring-boot-configuration-processor")
    }
}

// for report
jacoco {
    toolVersion = "0.8.6"
}

tasks.create("jacocoMerge", JacocoMerge::class) {
    group = "Reporting"
    gradle.afterProject {
        if (rootProject != this && plugins.hasPlugin("jacoco")) {
            executionData("$buildDir/jacoco/test.exec")
        }
    }
}

tasks.create("jacocoMergedReport", JacocoReport::class) {
    group = "Reporting"
    dependsOn("jacocoMerge")

    gradle.afterProject {
        if (project.rootProject != this && project.plugins.hasPlugin("jacoco")) {
            sourceDirectories.from += "$projectDir/src/main/kotlin"
            classDirectories.from.addAll(fileTree("$buildDir/classes/kotlin/main"))
        }
    }
    executionData(tasks.named<JacocoMerge>("jacocoMerge").get().destinationFile)
    reports {
        xml.isEnabled = true
        html.isEnabled = true
    }
}
