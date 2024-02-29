package io.jason.bootbase.application.port.out

import io.jason.bootbase.adapter.persistence.entity.User
import io.jason.bootbase.application.domain.model.UserModel

interface UserServiceAdapterPort {
    fun existsByUserId(userId: String): Boolean

    fun saveByUser(user: User): UserModel

}