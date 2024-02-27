package io.jason.bootbase

import io.jason.commonresponse.exception.BaseError
import org.springframework.http.HttpStatus

enum class TestError(
    val code: String,
    val status: HttpStatus,
    val message: String
)  {
    TEST_ERROR("CODE_ERROR", HttpStatus.BAD_REQUEST, "TEST_ERROR")
}