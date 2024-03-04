package io.jason.bootproduct

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication(exclude = [ DataSourceAutoConfiguration::class ])
@EnableMongoRepositories
class BootProductApplication

fun main(args: Array<String>) {
    runApplication<BootProductApplication>(*args)
}
