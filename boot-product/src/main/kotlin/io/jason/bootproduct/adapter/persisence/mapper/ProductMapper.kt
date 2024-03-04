package io.jason.bootproduct.adapter.persisence.mapper

import io.jason.bootproduct.adapter.persisence.entity.Product
import io.jason.bootproduct.application.domain.model.ProductModel
import io.jason.commonutils.mapper.MapperConverter

class ProductMapper: MapperConverter<Product, ProductModel>() {
    override fun toModel(entity: Product): ProductModel {
        return ProductModel(
            productId = entity.productId,
            productName = entity.productName,
            productPrice = entity.productPrice,
            productDescription = entity.productDescription
        )
    }

    override fun toEntity(model: ProductModel): Product {
        TODO("Not yet implemented")
    }
}