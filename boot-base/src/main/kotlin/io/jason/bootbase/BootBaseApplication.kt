package io.jason.bootbase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScans
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EntityScan
@ComponentScans
@EnableJpaRepositories(basePackages = ["io.jason.bootbase.adapter.persistence.repository"])
class BootBaseApplication

fun main(args: Array<String>) {
    runApplication<BootBaseApplication>(*args)
}
