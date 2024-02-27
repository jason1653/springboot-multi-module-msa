package io.jason.commonresponse.exception

import org.springframework.http.HttpStatus

class BaseErrorException(
    val status: HttpStatus,
    val code: String = "",
    override val message: String? = "",
) : RuntimeException(message) {
}