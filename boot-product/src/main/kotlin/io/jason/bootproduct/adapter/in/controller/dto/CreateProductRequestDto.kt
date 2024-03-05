package io.jason.bootproduct.adapter.`in`.controller.dto

data class CreateProductRequestDto (
    val productName: String,
    val productPrice: Double,
    val productDescription: String
)