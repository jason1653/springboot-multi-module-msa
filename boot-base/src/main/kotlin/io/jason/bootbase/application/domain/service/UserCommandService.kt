package io.jason.bootbase.application.domain.service

import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.bootbase.application.port.`in`.UserCommandUseCase
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class UserCommandService : UserCommandUseCase {
    override fun createUser(command: CreateUserCommandRequest): ResponseEntity<BaseResponse<CreateUserCommandResponse>> {
        return BaseResponse.success(
            BaseResponseSuccessEnum.CREATED,
            CreateUserCommandResponse(1111, "test", "test")
        )
    }
}