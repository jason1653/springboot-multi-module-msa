package io.jason.bootbase.application.core.domain


data class UserModel(
    val id: Long,
    val userId: String,
    val userName: String,
    val email: String
)
