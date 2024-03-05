package io.jason.bootbase.application.core.domain

data class CreateUserModel(
    val id: Long,
    val userId: String,
    val userName: String,
    val secretKey: String,
    val token: String,
    val refreshToken: String,
    val refreshSecretKey: String,
    val expiration: Long
) {

}