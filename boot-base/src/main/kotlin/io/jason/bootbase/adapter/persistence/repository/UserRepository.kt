package io.jason.bootbase.adapter.persistence.repository

import io.jason.bootbase.adapter.persistence.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<UserEntity, Long> {
    fun existsByUserId(userId: String): Boolean

    fun saveByUser(userEntity: UserEntity): UserEntity
}