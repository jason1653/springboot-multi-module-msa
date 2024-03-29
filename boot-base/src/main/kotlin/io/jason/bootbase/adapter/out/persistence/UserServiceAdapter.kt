package io.jason.bootbase.adapter.out.persistence

import io.jason.bootbase.adapter.out.persistence.entity.User
import io.jason.bootbase.adapter.out.persistence.mapper.UserMapper
import io.jason.bootbase.adapter.out.persistence.repository.UserRepository
import io.jason.bootbase.application.core.domain.UserModel
import io.jason.bootbase.application.port.out.UserServiceAdapterPort
import io.jason.commonutils.annotation.PersistenceAdapter


@PersistenceAdapter
class UserServiceAdapter(
    private val userRepository: UserRepository
) : UserServiceAdapterPort {

    override fun existsByUserId(userId: String): Boolean {
        return userRepository.existsByUserId(userId)
    }

    override fun saveByUser(user: User): UserModel {
        val user =  userRepository.save(user)
        return UserMapper().toModel(user);

    }

}