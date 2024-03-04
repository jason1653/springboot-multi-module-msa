package io.jason.bootproduct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootProductApplication

fun main(args: Array<String>) {
    runApplication<BootProductApplication>(*args)
}
