package io.jason.bootproduct.application.port.`in`

import io.jason.bootproduct.application.domain.model.ProductModel
import io.jason.bootproduct.application.dto.CreateProductDTO

interface ProductServiceUseCase {
    fun createProduct(createProductDTO: CreateProductDTO): ProductModel
}