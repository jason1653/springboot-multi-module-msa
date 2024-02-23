package io.jason.commonutils.exception

import org.springframework.http.HttpStatus

interface BaseError {
    val status: HttpStatus
    val code: String
    val message: String
}