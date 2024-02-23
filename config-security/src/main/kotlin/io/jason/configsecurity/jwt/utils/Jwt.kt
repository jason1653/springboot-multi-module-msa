package io.jason.configsecurity.jwt.utils

import io.jason.configsecurity.jwt.dto.GenerateTokenDto
import java.time.Duration

interface Jwt {
    fun <T> generateToken(subject: String, dto: T, duration: Duration): GenerateTokenDto

    fun decodeToken(subject: String, key: String, token: String)
}