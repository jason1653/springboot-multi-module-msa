package io.jason.bootbase.application.port.out

import io.jason.bootbase.adapter.out.persistence.entity.User
import io.jason.bootbase.application.core.domain.UserModel

interface UserServiceAdapterPort {
    fun existsByUserId(userId: String): Boolean

    fun saveByUser(user: User): UserModel

}