package io.jason.commonresponse.response

import org.springframework.http.ResponseEntity

class RestResponse<T>(
    private val baseResponse: BaseResponse<T>
) {
    fun toResponseEntity(): ResponseEntity<BaseResponse<T>> {
        return ResponseEntity.status(baseResponse.status).body(baseResponse)
    }
}