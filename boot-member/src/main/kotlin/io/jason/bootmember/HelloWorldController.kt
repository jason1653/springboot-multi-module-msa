package io.jason.bootmember

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/")
class HelloWorldController {

    @RequestMapping("/hello")
    fun hello(): String {
        return "Hello World"
    }
}