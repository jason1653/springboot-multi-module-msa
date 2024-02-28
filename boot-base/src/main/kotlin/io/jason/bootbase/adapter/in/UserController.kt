package io.jason.bootbase.adapter.`in`

import io.jason.bootbase.domain.port.`in`.CreateUserCommand
import io.jason.bootbase.domain.port.`in`.CreateUserCommandResult
import io.jason.bootbase.domain.port.`in`.UserCommandUseCase
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
    fun createUser(): ResponseEntity<BaseResponse<CreateUserCommandResult>> {
        val command = CreateUserCommand(
            userId = "test"
        )
        return userCommandUseCase.createUser(command)
    }
}