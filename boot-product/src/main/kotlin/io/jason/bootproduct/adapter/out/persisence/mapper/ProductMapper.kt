package io.jason.bootproduct.adapter.out.persisence.mapper

import io.jason.bootproduct.adapter.out.persisence.entity.Product
import io.jason.bootproduct.application.core.domain.ProductModel
import io.jason.commonutils.mapper.MapperConverter
import org.springframework.stereotype.Component

@Component
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