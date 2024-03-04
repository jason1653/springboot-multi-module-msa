package io.jason.bootproduct.application.port.`in`

import io.jason.bootproduct.application.dto.CreateProductDTO

interface ProductServiceUseCase {
    fun createProduct(createProductDTO: CreateProductDTO)
}