package io.jason.bootbase

import io.jason.commonresponse.exception.BaseError
import org.springframework.http.HttpStatus

enum class TestError(
    override val code: String,
    override val status: HttpStatus,
    override val message: String
) : BaseError {
    TEST_ERROR("CODE_ERROR", HttpStatus.BAD_REQUEST, "TEST_ERROR")
}