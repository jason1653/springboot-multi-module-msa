package io.jason.commonresponse.exception

import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class BaseExceptionHandler {
    @ExceptionHandler(BaseException::class)
    fun handleBaseException(ex: BaseException): ResponseEntity<BaseResponse<String>> {
        val response = BaseResponse.fail(
            ex.status,
            ex.message ?: "Not Found",
            ex.code
        )
        return ResponseEntity(response, HttpStatusCode.valueOf(response.status))
    }

    @ExceptionHandler(BaseErrorException::class)
    fun handleBaseErrorException(ex: BaseErrorException): ResponseEntity<BaseResponse<String>> {
        val response = BaseResponse.fail(
            ex.status,
            ex.message ?: "Internal Server Error",
            ex.code
        )
        return ResponseEntity(response, HttpStatusCode.valueOf(response.status))
    }
}