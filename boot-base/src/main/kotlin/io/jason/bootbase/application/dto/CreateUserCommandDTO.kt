package io.jason.bootbase.application.dto

data class CreateUserCommandDTO(
    val id: Long,
    val userId: String,
    val userName: String,
)