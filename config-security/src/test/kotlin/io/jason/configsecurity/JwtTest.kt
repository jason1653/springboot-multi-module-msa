package io.jason.configsecurity

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
}

data class UserData(
    val id: Int,
    val userName: String
)