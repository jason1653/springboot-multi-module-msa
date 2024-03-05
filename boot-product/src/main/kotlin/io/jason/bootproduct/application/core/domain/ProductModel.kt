package io.jason.bootproduct.application.core.domain

data class ProductModel(
    val productId: String,
    val productName: String,
    val productPrice: Long,
    val productDescription: String
)
