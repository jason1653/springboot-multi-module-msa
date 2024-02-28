package io.jason.bootbase.domain.port.`in`

import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.ResponseEntity

interface UserCommandUseCase {
    fun createUser(command: CreateUserCommand): ResponseEntity<BaseResponse<CreateUserCommandResult>>
}