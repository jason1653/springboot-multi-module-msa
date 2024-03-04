package io.jason.bootproduct.application.port.out

import io.jason.bootproduct.adapter.persisence.entity.Product
import io.jason.bootproduct.application.domain.model.ProductModel

interface ProductServiceAdapterPort {

    fun saveProduct(product: Product): ProductModel
}