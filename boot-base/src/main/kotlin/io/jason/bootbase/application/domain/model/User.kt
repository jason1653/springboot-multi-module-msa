package io.jason.bootbase.application.domain.model

data class User(
    val id: Long,
    val userId: String,
    val userName: String,
    val email: String
)