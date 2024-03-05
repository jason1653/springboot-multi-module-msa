package io.jason.bootbase.adapter.`in`.controller.request

data class CreateUserRequest (
    val userId: String = "",
    val userName: String = "",
    val userPassword: String = "",
)