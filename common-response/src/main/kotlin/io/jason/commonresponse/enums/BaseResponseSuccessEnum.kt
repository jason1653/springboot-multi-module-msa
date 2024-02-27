package io.jason.commonresponse.enums

import org.springframework.http.HttpStatus

enum class BaseResponseSuccessEnum(
    val httpStatus: HttpStatus
) {
    OK(HttpStatus.OK),
    CREATED(HttpStatus.CREATED),
    NO_CONTENT(HttpStatus.NO_CONTENT),
}