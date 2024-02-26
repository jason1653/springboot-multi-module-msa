package io.jason.bootbase

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("io.jason.**")
class BootBaseApplication

fun main(args: Array<String>) {
    runApplication<BootBaseApplication>(*args)
}
