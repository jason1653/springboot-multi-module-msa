package io.jason.commonresponse.exception

import org.springframework.http.HttpStatus

class BaseException(
    errCode: BaseError
) : RuntimeException(errCode.message) {
    val code: String = errCode.code
    val status: HttpStatus = errCode.status
}