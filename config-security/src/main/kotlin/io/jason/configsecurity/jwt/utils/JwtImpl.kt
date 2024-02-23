package io.jason.configsecurity.jwt.utils

import com.fasterxml.jackson.databind.ObjectMapper
import io.jason.configsecurity.jwt.dto.GenerateTokenDto
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.io.Encoders
import org.springframework.stereotype.Component
import java.time.Duration
import java.util.*


@Component
class JwtImpl : Jwt {
    private val objectMapper = ObjectMapper()

    override fun <T> generateToken(subject: String, dto: T, duration: Duration): GenerateTokenDto {
        val claimsMap = objectMapper.convertValue(dto, Map::class.java) as Map<String, Any>


        val now = Date()
        val validityLong = now.time + duration.toMillis()
        val validity = Date(validityLong)
        val key = Jwts.SIG.HS256.key().build()
        val secretString = Encoders.BASE64.encode(key.encoded)

        val token = Jwts.builder()
            .claims(claimsMap)
            .issuer("jason")
            .issuedAt(now)
            .subject(subject)
            .expiration(validity)
            .signWith(key)
            .compact()


        val generateTokenDTO = GenerateTokenDto(secretString, token, validityLong)

        return generateTokenDTO


    }

    override fun decodeToken(subject: String, key: String, token: String) {
        val secretKey = Encoders.BASE64
        val jwts = Jwts.parser()
            .build()
    }
}