package io.jason.bootbase.application.domain.service

import io.jason.bootbase.application.port.`in`.CreateUserCommand
import io.jason.bootbase.application.dto.CreateUserCommandDTO
import io.jason.bootbase.application.port.`in`.UserCommandUseCase
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service


@Service
class UserCommandService : UserCommandUseCase {
    override fun createUser(command: CreateUserCommand): ResponseEntity<BaseResponse<CreateUserCommandDTO>> {
        return BaseResponse.success(
            BaseResponseSuccessEnum.CREATED,
            CreateUserCommandDTO(1111, "test", "test")
        )
    }
}