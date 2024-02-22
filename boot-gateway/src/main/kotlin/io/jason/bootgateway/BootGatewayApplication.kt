package io.jason.bootgateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootGatewayApplication

fun main(args: Array<String>) {
    runApplication<BootGatewayApplication>(*args)
}
