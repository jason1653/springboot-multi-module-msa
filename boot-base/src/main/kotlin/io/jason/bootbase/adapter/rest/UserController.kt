package io.jason.bootbase.adapter.rest

import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.bootbase.application.port.`in`.UserCommandUseCase
import io.jason.commonresponse.response.BaseResponse
import io.jason.commonresponse.response.RestResponse
import io.jason.commonutils.annotation.WebAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping


@WebAdapter(path = "/users")
class UserController(
    private val userCommandUseCase: UserCommandUseCase
) {
    @GetMapping
    fun createUser(): ResponseEntity<BaseResponse<CreateUserCommandResponse>> {
        val command = CreateUserCommandRequest(
            userId = "test"
        )

        return RestResponse(userCommandUseCase.createUser(command)).toResponseEntity()
    }
}