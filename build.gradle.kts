plugins {
    id("io.ktor.plugin") version "2.3.12"
    kotlin("jvm") version "1.9.24"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain")
}

kotlin {
    jvmToolchain(17)
}

repositories {
    mavenCentral()
}

dependencies {
    // Ktor Core
    implementation("io.ktor:ktor-server-core:2.3.12")
    implementation("io.ktor:ktor-server-netty:2.3.12")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("io.ktor:ktor-server-config-yaml:2.3.12")
    implementation("io.ktor:ktor-server-status-pages:2.3.12")

    // Тести
    testImplementation("io.ktor:ktor-server-tests:2.3.12")   // Ktor тестування
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.9.24")  // kotlin.test
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:1.9.24") // JUnit підтримка
}


