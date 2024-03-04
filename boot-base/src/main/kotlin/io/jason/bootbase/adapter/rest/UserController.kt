package io.jason.bootbase.adapter.rest

import io.jason.bootbase.application.domain.model.UserModel
import io.jason.bootbase.application.dto.CreateUserCommandDTO
import io.jason.bootbase.application.port.`in`.UserServiceUseCase
import io.jason.commonresponse.response.BaseResponse
import io.jason.commonresponse.response.RestResponse
import io.jason.commonutils.annotation.WebAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@WebAdapter(path = "/users")
class UserController(
    private val userCommandUseCase: UserServiceUseCase
) {

    @PostMapping
    fun createUser(@RequestBody request: CreateUserCommandDTO): ResponseEntity<BaseResponse<UserModel>> {
        return RestResponse(userCommandUseCase.createUser(request)).toResponseEntity()
    }

}