package io.jason.bootbase.application.exception

import io.jason.commonresponse.exception.BaseError
import org.springframework.http.HttpStatus

enum class UserException(
    override val code: String,
    override val status: HttpStatus,
    override val message: String
): BaseError {
    NOT_EXISTS_USERID("UE-USERID-001", HttpStatus.NOT_FOUND, "회원아이디가 존재합니다"),
    NOT_EXISTS_USER("UE-USER-002", HttpStatus.NOT_FOUND, "회원이 존재하지 않습니다"),

}