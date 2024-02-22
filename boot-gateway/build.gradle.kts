tasks.getByName("bootJar").enabled = true
tasks.getByName("jar").enabled = false

extra["springCloudVersion"] = "2023.0.0"

dependencies {

    implementation("org.springframework.cloud:spring-cloud-starter-gateway")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}
