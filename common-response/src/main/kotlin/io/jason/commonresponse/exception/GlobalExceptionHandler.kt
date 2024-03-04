package io.jason.commonresponse.exception

import io.jason.commonresponse.enums.ExceptionEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    /**
     * 권한오류
     */
    @ExceptionHandler(AccessDeniedException::class)
    fun handleAccessDeniedException(ex: AccessDeniedException): ResponseEntity<BaseResponse<String>> {
        val message = ex.message ?: "접근권한이 없습니다."

        val response = BaseResponse.fail(
            ExceptionEnum.ACCESS_DENIED_EXCEPTION,
        )


        return ResponseEntity(response, HttpStatusCode.valueOf(response.status))
    }

    /**
     * NULL 오류
     */
    @ExceptionHandler(NullPointerException::class)
    fun handleNullPointerException(ex: NullPointerException): ResponseEntity<BaseResponse<String>> {
        val message = ex.message ?: "Null Pointer Exception"

        val response = BaseResponse.fail(
            ExceptionEnum.NULL_POINTER_EXCEPTION,
        )
        return ResponseEntity(response, HttpStatusCode.valueOf(response.status))
    }


    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(ex: HttpMessageNotReadableException): ResponseEntity<BaseResponse<String>> {
        val response = BaseResponse.fail(
            HttpStatus.BAD_REQUEST,
            "잘못된 요청입니다."
        )

        return ResponseEntity(response, HttpStatusCode.valueOf(response.status))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<BaseResponse<String>> {
        val messageList: MutableList<String?> = ArrayList()
        for (error in ex.bindingResult.fieldErrors) {
            messageList.add(error.defaultMessage)
        }

        val response = BaseResponse.fail(
            HttpStatus.BAD_REQUEST,
            messageList.joinToString(", ")
        )

        return ResponseEntity(response, HttpStatusCode.valueOf(response.status))
    }


}