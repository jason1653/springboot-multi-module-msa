
dependencies {
    implementation("org.springframework:spring-context:6.1.4")
    implementation("org.springframework:spring-webmvc:6.1.3")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation("org.springframework.security:spring-security-crypto")
    implementation("com.github.ulisesbocchio:jasypt-spring-boot-starter:3.0.5")
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")

    implementation(project(":common-logger"))

    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")
}

