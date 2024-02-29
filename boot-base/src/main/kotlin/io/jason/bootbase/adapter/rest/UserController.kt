package io.jason.bootbase.adapter.rest

import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.bootbase.application.port.`in`.UserCommandUseCase
import io.jason.commonresponse.response.BaseResponse
import io.jason.commonutils.annotation.WebAdapter
import org.springframework.web.bind.annotation.GetMapping


@WebAdapter(path = "/users")
class UserController(
    private val userCommandUseCase: UserCommandUseCase
) {
    @GetMapping
    fun createUser() {
        val command = CreateUserCommandRequest(
            userId = "test"
        )

    }
}