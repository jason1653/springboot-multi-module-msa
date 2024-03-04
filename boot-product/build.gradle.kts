val querydslVersion = "5.0.0"

tasks.getByName("bootJar").enabled = true
tasks.getByName("jar").enabled = false




dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")


    implementation(project(":config-security"))

    implementation(project(":common-utils"))
    implementation(project(":common-logger"))
    implementation(project(":common-response"))
}

