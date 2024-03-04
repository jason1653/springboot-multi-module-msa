package io.jason.bootproduct.adapter.rest

import io.jason.commonutils.annotation.WebAdapter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController


@WebAdapter("product")
class ProductController {

    @PostMapping
    fun createProduct() {
        println("Product created")
    }
}