package io.jason.configsecurity.jwt.dto

data class GenerateTokenDto(
    val secretKey: String,
    val token: String?,
    val expiration: Long
)
