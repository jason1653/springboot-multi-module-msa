package io.jason.bootbase

import io.jason.commonlogger.annotation.ElapseLoggable
import io.jason.commonlogger.util.LoggerUtil
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.exception.BaseErrorException
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/")
class HelloWorldController {

    private val logger = LoggerUtil()


    @RequestMapping("/hello")
    @ElapseLoggable
    fun hello(): ResponseEntity<BaseResponse<String>> {

        logger.info("Hello World")


//        throw BaseErrorException(
//            HttpStatus.BAD_REQUEST,
//            "TEST_ERROR",
//            "TEST_ERROR"
//        )
        return BaseResponse.success(
            BaseResponseSuccessEnum.OK,
            "TEST"
        )


    }

    @ElapseLoggable
    @RequestMapping("/hello2")
    fun hello2(hello2Dto: Hello2Dto): ResponseEntity<BaseResponse<String>> {
        return BaseResponse.success(
            BaseResponseSuccessEnum.OK,
            ""
        )
    }

    @RequestMapping("/hello3/{id}")
    fun hello3(@PathVariable("id") id: String): String {
        return "OK"
    }
}