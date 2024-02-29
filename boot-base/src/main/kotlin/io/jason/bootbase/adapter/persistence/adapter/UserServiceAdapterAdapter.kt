package io.jason.bootbase.adapter.persistence.adapter

import io.jason.bootbase.adapter.persistence.entity.User
import io.jason.bootbase.adapter.persistence.repository.UserRepository
import io.jason.bootbase.application.domain.model.UserModel
import io.jason.bootbase.application.port.out.UserServiceAdapterPort
import io.jason.commonutils.annotation.PersistenceAdapter
import io.jason.commonutils.mapper.ModelConverter


@PersistenceAdapter
class UserServiceAdapterAdapter(
    private val userRepository: UserRepository
) : UserServiceAdapterPort {

    override fun existsByUserId(userId: String): Boolean {
        return userRepository.existsByUserId(userId)
    }

    override fun saveByUser(user: User): UserModel {
        val user =  userRepository.save(user)
        return ModelConverter.toModel(user, UserModel::class.java)!!
    }

}