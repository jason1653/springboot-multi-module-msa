package io.jason.bootbase.application.dto

data class CreateUserCommandResponse(
    val id: Long,
    val userId: String,
    val userName: String,
)