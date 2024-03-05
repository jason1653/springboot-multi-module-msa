package io.jason.bootbase.application.core.usecase

import io.jason.bootbase.adapter.out.persistence.entity.User
import io.jason.bootbase.application.core.dto.CreateUserResponseDto
import io.jason.bootbase.application.core.exception.UserException
import io.jason.bootbase.application.port.`in`.UserServiceUseCase
import io.jason.bootbase.application.port.out.UserServiceAdapterPort
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.exception.BaseException
import io.jason.commonresponse.response.BaseResponse
import io.jason.commonutils.crypto.AesCryptoUtil
import io.jason.configsecurity.jwt.utils.Jwt
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.time.Duration


@Service
class UserService(
    private val userServiceAdapterPort: UserServiceAdapterPort,
    private val cryptoUtil: AesCryptoUtil,
    private val passwordEncoder: PasswordEncoder,
    private val jwt: Jwt,
) : UserServiceUseCase {

    @Transactional(rollbackOn = [BaseException::class])
    override fun createUser(user: User): BaseResponse<CreateUserResponseDto> {


        val existsUserId = userServiceAdapterPort.existsByUserId(user.userId)
        if(existsUserId) {
            throw BaseException(UserException.NOT_EXISTS_USERID)
        }

        val password = passwordEncoder.encode(user.pwd)
        val userModel = userServiceAdapterPort.saveByUser(user)

        val token = jwt.generateToken(userModel.userId, userModel, Duration.ofHours(1))
        val refreshToken = jwt.generateToken(userModel.userId, userModel, Duration.ofHours(24))


        val createUserResponseDto = CreateUserResponseDto(
            id = userModel.id,
            userId = userModel.userId,
            userName = userModel.userName,
            token = token.token!!,
            secretKey = token.secretKey,
            refreshToken = refreshToken.token!!,
            refreshSecretKey = refreshToken.secretKey,
            expiration = token.expiration
        )

        return BaseResponse.success(
            status = BaseResponseSuccessEnum.CREATED,
            body = createUserResponseDto
        )
    }
}