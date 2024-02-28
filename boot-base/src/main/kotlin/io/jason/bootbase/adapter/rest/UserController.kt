package io.jason.bootbase.adapter.rest

import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.bootbase.application.port.`in`.UserCommandUseCase
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user")
class UserController(
    private val userCommandUseCase: UserCommandUseCase
) {
    @PostMapping
    fun createUser(): ResponseEntity<BaseResponse<CreateUserCommandResponse>> {
        val command = CreateUserCommandRequest(
            userId = "test"
        )
        return userCommandUseCase.createUser(command)
    }
}