plugins {
    kotlin("jvm") version "2.1.10"
    application
}

group = "com.cavin.assistant"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3") // Coroutines for async tasks
    implementation("ch.qos.logback:logback-classic:1.4.12") // Logging support

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(23)
}

application {
    mainClass.set("com.cavin.assistant.MainKt") // Ensure this matches your Main.kt package path
}
