package io.jason.bootbase.adapter.persistence.adapter

import io.jason.bootbase.adapter.persistence.entity.UserEntity
import io.jason.bootbase.application.exception.UserException
import io.jason.bootbase.adapter.persistence.repository.UserRepository
import io.jason.bootbase.application.domain.model.User
import io.jason.bootbase.application.port.out.UserServiceAdapterPort
import io.jason.commonresponse.exception.BaseException
import io.jason.commonutils.annotation.PersistenceAdapter
import io.jason.commonutils.mapper.ModelConverter
import io.jason.configsecurity.config.PasswordConfig
import jakarta.transaction.Transactional

@PersistenceAdapter
class UserServiceAdapterAdapter(
    private val userRepository: UserRepository,
) : UserServiceAdapterPort {

    override fun existsByUserId(userId: String): Boolean {
        return userRepository.existsByUserId(userId)
    }

    override fun saveByUser(userEntity: UserEntity): User {
        val userEntity =  userRepository.save(userEntity)
        return ModelConverter.toModel(userEntity, User::class.java)!!
    }


}