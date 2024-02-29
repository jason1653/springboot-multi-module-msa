package io.jason.bootbase.application.port.out

import io.jason.bootbase.adapter.persistence.entity.UserEntity
import io.jason.bootbase.application.domain.model.User

interface UserServiceAdapterPort {
    fun existsByUserId(userId: String): Boolean

    fun saveByUser(userEntity: UserEntity): User

}