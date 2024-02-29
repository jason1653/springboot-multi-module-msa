package io.jason.bootbase.application.port.`in`

import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.commonresponse.response.BaseResponse

interface UserServiceUseCase {
    fun createUser(command: CreateUserCommandRequest): BaseResponse<CreateUserCommandResponse>
}