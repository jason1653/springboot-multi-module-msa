package io.jason.bootmember

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootMemberApplication

fun main(args: Array<String>) {
    runApplication<BootMemberApplication>(*args)
}
