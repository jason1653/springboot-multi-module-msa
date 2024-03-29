package io.jason.bootbase.adapter.out.persistence.mapper

import io.jason.bootbase.adapter.out.persistence.entity.User
import io.jason.bootbase.application.core.domain.UserModel
import io.jason.commonutils.mapper.MapperConverter
import org.springframework.stereotype.Component


@Component
class UserMapper : MapperConverter<User, UserModel>() {
    override fun toModel(entity: User): UserModel {
        return UserModel(
            id = entity.id!!,
            userId = entity.userId,
            userName = entity.userName,
            email = entity.email
        )
    }

    override fun toEntity(model: UserModel): User {
        return User().apply {
            id = model.id
            userId = model.userId
            userName = model.userName
            email = model.email
        }
    }

}