import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions") version "0.48.0"
    application
    
    id("io.freefair.lombok") version "8.6"
}

application {
    mainClass.set("io.hexlet.App")
}

group = "exercise"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:6.1.3")

    implementation("gg.jte:jte:3.1.9")
    implementation("io.javalin:javalin-rendering:6.1.3")
    implementation("org.slf4j:slf4j-simple:2.0.7")
    implementation("net.datafaker:datafaker:2.0.1")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("com.konghq:unirest-java:3.13.0")
    testImplementation("org.hamcrest:hamcrest-core:2.2")
    testImplementation("org.assertj:assertj-core:3.24.2")
    implementation("org.apache.commons:commons-lang3:3.13.0")
}

tasks.test {
    useJUnitPlatform()
    // https://technology.lastminute.com/junit5-kotlin-and-gradle-dsl/
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.PASSED, TestLogEvent.SKIPPED)
        // showStackTraces = true
        // showCauses = true
        showStandardStreams = true
    }
}

