package io.jason.commonresponse.exception

import io.jason.commonresponse.response.BaseResponse
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
        return response
    }
}