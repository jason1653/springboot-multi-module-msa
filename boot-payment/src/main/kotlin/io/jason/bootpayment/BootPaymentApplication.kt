package io.jason.bootpayment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootPaymentApplication

fun main(args: Array<String>) {
    runApplication<BootPaymentApplication>(*args)
}
