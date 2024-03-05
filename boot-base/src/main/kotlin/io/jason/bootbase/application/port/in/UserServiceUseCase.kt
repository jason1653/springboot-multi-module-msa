package io.jason.bootbase.application.port.`in`

import io.jason.bootbase.adapter.out.persistence.entity.User
import io.jason.bootbase.application.core.domain.CreateUserModel
import io.jason.bootbase.application.core.domain.UserModel
import io.jason.commonresponse.response.BaseResponse

interface UserServiceUseCase {
    fun createUser(user: User): BaseResponse<CreateUserModel>
}