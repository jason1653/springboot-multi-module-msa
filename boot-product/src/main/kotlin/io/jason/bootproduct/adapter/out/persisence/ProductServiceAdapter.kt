package io.jason.bootproduct.adapter.out.persisence

import io.jason.bootproduct.adapter.out.persisence.entity.Product
import io.jason.bootproduct.adapter.out.persisence.mapper.ProductMapper
import io.jason.bootproduct.adapter.out.persisence.repository.ProductRepository
import io.jason.bootproduct.application.core.domain.ProductModel
import io.jason.bootproduct.application.port.out.ProductServiceAdapterPort
import io.jason.commonutils.annotation.PersistenceAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


@PersistenceAdapter
class ProductServiceAdapter(
    private val productRepository: ProductRepository,
) : ProductServiceAdapterPort {
    private fun createProductId(): String {
        val now = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("yyyyMMddhhmmss")
        val formatted = now.format(formatter)

        val randomNumber = Random.nextInt(100000, 999999)

        return "${formatted}${randomNumber}"
    }

    override fun saveProduct(product: Product): ProductModel {

        val productId = createProductId()
        product.productId = productId

        val productData = productRepository.save(product)
        return ProductMapper().toModel(productData)
    }

    override fun findById(productId: String): Product? {
        return productRepository.findById(productId).orElse(null)
    }
}