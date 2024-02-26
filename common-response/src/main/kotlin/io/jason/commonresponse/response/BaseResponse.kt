package io.jason.commonresponse.response

import io.jason.commonresponse.exception.BaseError
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

class BaseResponse<T>(
    val code: String = "",
    val message: Any = "",
    val status: Int,
    val body: T,
) {
    companion object {
        fun <T> success(status: HttpStatus, body: T, message: Any = "", code: String = ""): ResponseEntity<BaseResponse<T>> {
            return ResponseEntity(
                BaseResponse(
                    code = code,
                    message = message,
                    status = status.value(),
                    body = body,
                ),
                status
            )
        }

        fun fail(baseError: BaseError): ResponseEntity<BaseResponse<String>> {
            return ResponseEntity(
                BaseResponse(
                    code = baseError.code,
                    message = baseError.message,
                    status = baseError.status.value(),
                    body = "",
                ),
                baseError.status
            )
        }

        fun fail(status: HttpStatus, message: Any, code: String = ""): ResponseEntity<BaseResponse<String>> {
            return ResponseEntity(
                BaseResponse(
                    code = code,
                    message = message,
                    status = status.value(),
                    body = "",
                ),
                status
            )
        }
    }
}