package io.jason.configsecurity.jwt.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
open class DecodeTokenDto {
    val iss: String? = null
    val sub: String? = null
    val iat: Long? = null
    val exp: Long? = null


}


