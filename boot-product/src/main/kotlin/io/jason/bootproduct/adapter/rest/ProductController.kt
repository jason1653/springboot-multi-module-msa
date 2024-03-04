package io.jason.bootproduct.adapter.rest

import io.jason.bootproduct.application.dto.CreateProductDTO
import io.jason.bootproduct.application.port.`in`.ProductServiceUseCase
import io.jason.commonutils.annotation.WebAdapter
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@WebAdapter("product")
class ProductController(
    private val prousectServiceUseCase: ProductServiceUseCase
) {

    @PostMapping
    fun createProduct(@RequestBody createProductDTO: CreateProductDTO) {
        prousectServiceUseCase.createProduct(createProductDTO)
    }
}