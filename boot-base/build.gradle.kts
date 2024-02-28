val querydslVersion = "5.0.0"

tasks.getByName("bootJar").enabled = true
tasks.getByName("jar").enabled = false




dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j:8.3.0")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.querydsl:querydsl-jpa:$querydslVersion:jakarta")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jakarta")


    implementation(project(":config-jpa"))
    implementation(project(":config-security"))

    implementation(project(":common-logger"))
    implementation(project(":common-response"))
}

