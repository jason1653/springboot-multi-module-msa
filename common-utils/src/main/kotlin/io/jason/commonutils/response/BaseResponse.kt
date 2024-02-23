package io.jason.commonutils.response

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
    }
}