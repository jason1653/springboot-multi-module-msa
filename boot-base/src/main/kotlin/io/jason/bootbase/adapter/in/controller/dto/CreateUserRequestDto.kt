package io.jason.bootbase.adapter.`in`.controller.dto

data class CreateUserRequestDto (
    val userId: String = "",
    val userName: String = "",
    val userPassword: String = "",
)