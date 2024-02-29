package io.jason.bootbase.application.domain.model


data class UserModel(
    val id: Long,
    val userId: String,
    val userName: String,
    val email: String
)
