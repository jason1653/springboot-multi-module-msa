package io.jason.bootbase.adapter.out.persistence.repository

import io.jason.bootbase.adapter.out.persistence.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : JpaRepository<User, Long> {
    fun existsByUserId(userId: String): Boolean

}