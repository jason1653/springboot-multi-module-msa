package io.jason.bootproduct.application.port.out

import io.jason.bootproduct.adapter.out.persisence.entity.Product
import io.jason.bootproduct.application.core.domain.ProductModel

interface ProductServiceAdapterPort {

    fun saveProduct(product: Product): ProductModel

    fun findById(productId: String): Product?
}