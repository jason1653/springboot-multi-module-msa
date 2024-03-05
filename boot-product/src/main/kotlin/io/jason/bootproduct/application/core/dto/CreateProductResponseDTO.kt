package io.jason.bootproduct.application.core.dto

data class CreateProductResponseDTO(
    val productName: String,
    val productPrice: Double,
    val productDescription: String
)
