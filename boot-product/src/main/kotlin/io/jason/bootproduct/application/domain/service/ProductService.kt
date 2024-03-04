package io.jason.bootproduct.application.domain.service

import io.jason.bootproduct.adapter.persisence.entity.Product
import io.jason.bootproduct.application.domain.model.ProductModel
import io.jason.bootproduct.application.dto.CreateProductDTO
import io.jason.bootproduct.application.port.`in`.ProductServiceUseCase
import io.jason.bootproduct.application.port.out.ProductServiceAdapterPort
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productServiceAdapterPort: ProductServiceAdapterPort
) : ProductServiceUseCase {
    override fun createProduct(createProductDTO: CreateProductDTO): ProductModel {
        val product = Product().apply {
            productName = createProductDTO.productName
            productPrice = createProductDTO.productPrice
            productDescription = createProductDTO.productDescription
        }
        val productModel = productServiceAdapterPort.saveProduct(product)

        return productModel

    }
}