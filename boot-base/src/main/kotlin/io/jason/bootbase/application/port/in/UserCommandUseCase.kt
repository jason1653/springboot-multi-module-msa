package io.jason.bootbase.application.port.`in`

import io.jason.bootbase.application.dto.CreateUserCommandDTO
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.ResponseEntity

interface UserCommandUseCase {
    fun createUser(command: CreateUserCommand): ResponseEntity<BaseResponse<CreateUserCommandDTO>>
}