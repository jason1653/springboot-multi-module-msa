package io.jason.commonresponse.response

import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.exception.BaseError
import org.springframework.http.HttpStatus


class BaseResponse<T>(
    val code: String = "",
    val message: Any = "",
    val status: Int,
    val body: T,
) {



    companion object {
        fun <T> success(status: BaseResponseSuccessEnum, body: T, message: Any = "", code: String = ""): BaseResponse<T> {
            return BaseResponse(
                code = code,
                message = message,
                status = status.httpStatus.value(),
                body = body,
            )
        }

        fun fail(baseError: BaseError): BaseResponse<String> {
            return BaseResponse(
                    code = baseError.code,
                    message = baseError.message,
                    status = baseError.status.value(),
                    body = "",
                )
        }

        fun fail(status: HttpStatus, message: Any, code: String = ""): BaseResponse<String> {
            return BaseResponse(
                code = code,
                message = message,
                status = status.value(),
                body = "",
            )

        }
    }


}