package io.jason.bootbase.application.service

import io.jason.bootbase.domain.port.`in`.CreateUserCommand
import io.jason.bootbase.domain.port.`in`.CreateUserCommandResult
import io.jason.bootbase.domain.port.`in`.UserCommandUseCase
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class UserCommandService : UserCommandUseCase {
    override fun createUser(command: CreateUserCommand): ResponseEntity<BaseResponse<CreateUserCommandResult>> {
        return BaseResponse.success(
            BaseResponseSuccessEnum.CREATED,
            CreateUserCommandResult(1111, "test", "test")
        )
    }
}