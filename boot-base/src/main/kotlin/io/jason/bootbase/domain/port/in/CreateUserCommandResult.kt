package io.jason.bootbase.domain.port.`in`

data class CreateUserCommandResult(
    val id: Long,
    val userId: String,
    val userName: String,
)