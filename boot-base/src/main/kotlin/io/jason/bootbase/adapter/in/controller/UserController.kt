package io.jason.bootbase.adapter.`in`.controller

import io.jason.bootbase.adapter.`in`.controller.request.CreateUserRequest
import io.jason.bootbase.adapter.out.persistence.entity.User
import io.jason.bootbase.application.core.domain.CreateUserModel
import io.jason.bootbase.application.core.domain.UserModel
import io.jason.bootbase.application.port.`in`.UserServiceUseCase
import io.jason.commonresponse.response.BaseResponse
import io.jason.commonresponse.response.RestResponse
import io.jason.commonutils.annotation.WebAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@WebAdapter(path = "/users")
class UserController(
    private val userCommandUseCase: UserServiceUseCase
) {

    @PostMapping
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<BaseResponse<CreateUserModel>> {
        val userEntity = User().apply {
            userId = request.userId
            userName = request.userName
            pwd = request.userPassword
        }
        return RestResponse(userCommandUseCase.createUser(userEntity)).toResponseEntity()
    }

}