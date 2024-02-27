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
        val token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlck5hbWUiOiJqYXNvbiIsImlzcyI6Imphc29uIiwiaWF0IjoxNzA5MDAyMzI1LCJzdWIiOiJ0ZXN0IiwiZXhwIjoxNzA5MDM4MzI1fQ.YtXwxt4dM1mqvqF3nS9UwCBPtFyAFLYg6wdhttBPNyY"
        val secretKey = "2PRbTF4u9vKaX4M987wyusJb6yUq2itDJdqHFmFzS4U="
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


