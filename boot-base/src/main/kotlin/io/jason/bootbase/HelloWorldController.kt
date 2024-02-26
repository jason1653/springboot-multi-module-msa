package io.jason.bootbase

import io.jason.commonresponse.exception.BaseException
import io.jason.commonresponse.response.BaseResponse
import io.jason.configsecurity.logger.LoggerUtil
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/")
class HelloWorldController {

    private val logger = LoggerUtil()

    @RequestMapping("/hello")
    fun hello(): ResponseEntity<BaseResponse<String>> {

        logger.info("Hello World")

//        throw BaseException(TestError.TEST_ERROR)
        return BaseResponse.success(
            HttpStatus.CREATED,
            "TEST"
        )
    }
}