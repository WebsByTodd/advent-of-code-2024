plugins {
    kotlin("jvm") version "2.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("com.diffplug.selfie:selfie-runner-junit5:2.4.1")
}

tasks.test {
    useJUnitPlatform()
    environment(project.properties.filterKeys{it == "selfie"}) // optional, see "Overwrite everything" below
    inputs.files(fileTree("src/test") { // optional, improves up-to-date checking
        include("**/*.ss")
    })
}