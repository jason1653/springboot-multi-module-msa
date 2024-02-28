package io.jason.bootbase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan("io.jason.**")
@EntityScan
@EnableJpaRepositories
class BootBaseApplication

fun main(args: Array<String>) {
    runApplication<BootBaseApplication>(*args)
}
