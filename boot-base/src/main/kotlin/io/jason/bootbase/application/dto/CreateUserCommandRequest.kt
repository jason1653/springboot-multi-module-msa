package io.jason.bootbase.application.dto

data class CreateUserCommandRequest(
    val userId: String = "",
    val userName: String = "",
    val userPassword: String = "",
)
