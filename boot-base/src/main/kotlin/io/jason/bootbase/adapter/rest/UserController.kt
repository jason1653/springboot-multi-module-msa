package io.jason.bootbase.adapter.rest

import io.jason.bootbase.application.port.`in`.UserServiceUseCase
import io.jason.commonutils.annotation.WebAdapter


@WebAdapter(path = "/users")
class UserController(
    private val userCommandUseCase: UserServiceUseCase
) {

}