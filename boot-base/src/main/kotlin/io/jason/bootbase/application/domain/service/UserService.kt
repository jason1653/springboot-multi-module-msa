package io.jason.bootbase.application.domain.service

import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.bootbase.application.port.`in`.UserServiceUseCase
import io.jason.bootbase.application.port.out.UserServicePort
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userServicePort: UserServicePort
) : UserServiceUseCase {
    override fun createUser(command: CreateUserCommandRequest): BaseResponse<CreateUserCommandResponse> {
        return BaseResponse.success(
            status = BaseResponseSuccessEnum.CREATED,
            body = CreateUserCommandResponse(
                id = 0L,
                userId = command.userId,
                userName = "test"
            )
        )
    }
}