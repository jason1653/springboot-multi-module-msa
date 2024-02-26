package io.jason.configsecurity.interceptor

import io.jason.configsecurity.logger.LoggerUtil
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor


@Component
class JwtAuthInterceptor : HandlerInterceptor {
    private val logger = LoggerUtil()

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {

        return true
    }


}