package io.jason.bootbase.application.port.`in`

import io.jason.bootbase.application.domain.model.UserModel
import io.jason.bootbase.application.dto.CreateUserCommandDTO
import io.jason.commonresponse.response.BaseResponse

interface UserServiceUseCase {
    fun createUser(command: CreateUserCommandDTO): BaseResponse<UserModel>
}