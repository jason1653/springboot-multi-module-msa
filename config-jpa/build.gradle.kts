
plugins {
    val kotlinVersion = "1.9.22"
    kotlin("plugin.jpa") version kotlinVersion
}

val querydslVersion = "5.0.0"

apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")

    implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")
}
