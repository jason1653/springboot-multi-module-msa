package io.jason.bootproduct.adapter.out.persisence.message

data class PaymentSuccessMessageDto(
    val uid: Long,
    val productId: String,
    val productName: String,
    val productPrice: Long,
) {
}