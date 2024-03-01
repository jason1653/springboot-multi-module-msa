package io.jason.bootbase.application.dto

data class CreateUserCommandDTO(
    val userId: String = "",
    val userName: String = "",
    val userPassword: String = "",
)
