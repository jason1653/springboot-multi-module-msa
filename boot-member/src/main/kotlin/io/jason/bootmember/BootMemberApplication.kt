package io.jason.bootmember

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication()
@ComponentScan("io.jason.**")

class BootMemberApplication

fun main(args: Array<String>) {
    runApplication<BootMemberApplication>(*args)
}
