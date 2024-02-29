package io.jason.bootbase.application.domain.service

import io.jason.bootbase.adapter.persistence.entity.User
import io.jason.bootbase.application.dto.CreateUserCommandRequest
import io.jason.bootbase.application.dto.CreateUserCommandResponse
import io.jason.bootbase.application.exception.UserException
import io.jason.bootbase.application.port.`in`.UserServiceUseCase
import io.jason.bootbase.application.port.out.UserServiceAdapterPort
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.exception.BaseException
import io.jason.commonresponse.response.BaseResponse
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userServiceAdapterPort: UserServiceAdapterPort,
//    private val passwordEncoder: PasswordEncoder
) : UserServiceUseCase {

    @Transactional(rollbackOn = [BaseException::class])
    override fun createUser(command: CreateUserCommandRequest): BaseResponse<CreateUserCommandResponse> {

        val existsUserId = userServiceAdapterPort.existsByUserId(command.userId)
        if(!existsUserId) {
            throw BaseException(UserException.NOT_EXISTS_USER)
        }

//        val password = passwordEncoder.encode(command.userPassword)
        val user = User().apply {
            userId = command.userId
            userName = command.userName
            pwd = "test"
            email = "test@email.com"
        }



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