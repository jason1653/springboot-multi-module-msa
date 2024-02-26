package io.jason.configsecurity.filter

import io.jason.configsecurity.logger.LoggerUtil
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component

@Component
class LogginFilter : Filter {

    private val logger = LoggerUtil()
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req = request as HttpServletRequest
        val res = response as HttpServletResponse

        val startTime = System.currentTimeMillis()
        logger.info("[S] ---------- [${req.method}] ${req.requestURI} ----------")

        chain?.doFilter(req, res)

        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime

        logger.info("[E] ---------- [${req.method}] ${req.requestURI} ---------- $duration ms")
    }

}