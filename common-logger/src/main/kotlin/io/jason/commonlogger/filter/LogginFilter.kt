package io.jason.commonlogger.filter

import io.jason.commonlogger.util.LoggerUtil
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.util.ContentCachingRequestWrapper

@Component
class LogginFilter : Filter {

    private val logger = LoggerUtil()
    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req = request as HttpServletRequest
        val res = response as HttpServletResponse

        val wrapper = ContentCachingRequestWrapper(req)

        val startTime = System.currentTimeMillis()
        logger.info("[Controller - S] ---------- [${req.method}] ${req.requestURI} ----------")

        val requestBody = wrapper.contentAsByteArray.decodeToString()
        if(requestBody.isNotEmpty()) {
            logger.info("[Request-Body]: $requestBody")
        }


        // 쿼리 문자열 로깅
        val queryString = request.queryString?.let { "$it" } ?: ""
        if(queryString.isNotEmpty()) {
            logger.info("[Request-Query]: $queryString")
        }

        chain?.doFilter(req, res)

        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime

        logger.info("[Controller - E] ---------- [${req.method}] ${req.requestURI} ---------- $duration ms")


    }

}