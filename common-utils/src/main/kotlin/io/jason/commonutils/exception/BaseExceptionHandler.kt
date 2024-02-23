package io.jason.commonutils.exception

import io.jason.commonutils.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class BaseExceptionHandler {
    @ExceptionHandler(BaseException::class)
    fun handleBaseException(ex: BaseException): ResponseEntity<BaseResponse<String>> {
        println("BaseException")
        val response = BaseResponse.fail(
            ex.status,
            ex.message ?: "Not Found",
            ex.code
        )
        return response
    }
}