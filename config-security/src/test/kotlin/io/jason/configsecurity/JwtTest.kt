package io.jason.configsecurity

import io.jason.configsecurity.jwt.dto.DecodeTokenDto
import io.jason.configsecurity.jwt.utils.Jwt
import io.jason.configsecurity.jwt.utils.JwtImpl
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import java.time.Duration


class JwtTest
{
    private lateinit var jwt: Jwt

    @BeforeEach
    fun setUp() {
        jwt = JwtImpl()
    }

    @Test
    fun `test jwt token`() {
        val userData = UserData(1, "jason")
        val token = jwt.generateToken("test", userData, Duration.ofHours(10))

        println(token.secretKey)
        println(token.token)
    }

    @Test
    fun `token to decode`() {
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlck5hbWUiOiJqYXNvbiIsImlzcyI6Imphc29uIiwiaWF0IjoxNzA4Njc0NjA4LCJzdWIiOiJ0ZXN0IiwiZXhwIjoxNzA4NzEwNjA4fQ.joAIiYW8jBlfg5VitYd-8sMvERwea6da8MUA11UCL9E"
        val secretKey = "txGWnBLyBTaCq9PDzEWpL8U9Dw0a0vopD39rQ7Rb/RM="
        jwt.decodeToken("test", secretKey, token, UserData2::class.java)
    }
}

data class UserData(
    val id: Int,
    val userName: String,
)


data class UserData2(
    val id: Int,
    val userName: String,
    val iss: String,
    val sub: String,
    val iat: Long,
    val exp: Long,
)


