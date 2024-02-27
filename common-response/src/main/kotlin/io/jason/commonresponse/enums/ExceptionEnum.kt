package io.jason.commonresponse.enums

import io.jason.commonresponse.exception.BaseError
import org.springframework.http.HttpStatus

enum class ExceptionEnum(
    override val status: HttpStatus,
    override val code: String,
    override val message: String
) : BaseError {
    NULL_POINTER_EXCEPTION(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "500",
        "Null Pointer Exception"
    ),
    ACCESS_DENIED_EXCEPTION(
        HttpStatus.FORBIDDEN,
        "403",
        "접근권한이 없습니다."
    ),
    HTTP_MESSAGE_NOT_READABLE_EXCEPTION(
        HttpStatus.BAD_REQUEST,
        "400",
        "데이터 형식이 잘못되었습니다."
    ),
    HTTP_MEDIA_TYPE_NOT_SUPPORTED_EXCEPTION(
        HttpStatus.UNSUPPORTED_MEDIA_TYPE,
        "415",
        "지원하지 않는 미디어 타입입니다."
    ),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED_EXCEPTION(
        HttpStatus.METHOD_NOT_ALLOWED,
        "405",
        "지원하지 않는 메소드입니다."
    ),
    METHOD_ARGUMENT_NOT_VALID_EXCEPTION(
        HttpStatus.BAD_REQUEST,
        "400",
        "잘못된 요청입니다."
    ),
    NO_HANDLER_FOUND_EXCEPTION(
        HttpStatus.NOT_FOUND,
        "404",
        "요청한 페이지를 찾을 수 없습니다."
    ),
    INTERNAL_SERVER_ERROR(
        HttpStatus.INTERNAL_SERVER_ERROR,
        "500",
        "서버 내부 오류입니다."
    )
}