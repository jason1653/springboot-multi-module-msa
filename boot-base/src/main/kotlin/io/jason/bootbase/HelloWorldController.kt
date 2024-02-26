package io.jason.bootbase

import io.jason.commonresponse.exception.BaseException
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController



@RestController
@RequestMapping("/")
class HelloWorldController {



    @RequestMapping("/hello")
    fun hello(): ResponseEntity<BaseResponse<String>> {


        throw BaseException(TestError.TEST_ERROR)
        return BaseResponse.success(
            HttpStatus.CREATED,
            "TEST"
        )
    }
}