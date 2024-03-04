val querydslVersion = "5.0.0"

tasks.getByName("bootJar").enabled = true
tasks.getByName("jar").enabled = false




dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j:8.3.0")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.security:spring-security-crypto")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")

    implementation("org.springframework.kafka:spring-kafka:3.1.2")

    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")


    implementation(project(":config-jpa"))
    implementation(project(":config-security"))

    implementation(project(":common-utils"))
    implementation(project(":common-logger"))
    implementation(project(":common-response"))
}

