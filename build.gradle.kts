import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    `maven-publish`
    application
}

group = "io.arctic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.arctic.nanoId"
            artifactId = "library"
            version = "1.0"

            from(components["java"])
        }
    }
}