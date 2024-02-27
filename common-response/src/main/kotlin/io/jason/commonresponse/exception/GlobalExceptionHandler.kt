package io.jason.commonresponse.exception

import io.jason.commonresponse.enums.ExceptionEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
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
        return response
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
        return response
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

        return response
    }



}