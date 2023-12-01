plugins {
    id("java")
    id("io.qameta.allure") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
    testImplementation("com.squareup.okhttp3:okhttp:4.10.0")
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("io.qameta.allure:allure-junit5:2.24.0")
    testImplementation("io.qameta.allure:allure-okhttp:2.24.0")
    implementation("org.json:json:20231013")
    implementation("org.apache.logging.log4j:log4j-api:2.22.0")
    implementation("org.apache.logging.log4j:log4j-core:2.22.0")
    implementation("org.slf4j:slf4j-api:2.0.5")
    implementation("org.slf4j:slf4j-simple:2.0.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")

}

tasks.test {
    useJUnitPlatform()
}
