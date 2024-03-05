package io.jason.bootproduct.adapter.`in`.controller

import io.jason.bootproduct.adapter.`in`.controller.dto.CreateProductRequestDto
import io.jason.bootproduct.adapter.out.persisence.entity.Product
import io.jason.bootproduct.application.core.domain.ProductModel
import io.jason.bootproduct.application.port.`in`.ProductServiceUseCase
import io.jason.commonresponse.response.BaseResponse
import io.jason.commonresponse.response.RestResponse
import io.jason.commonutils.annotation.WebAdapter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


@WebAdapter("product")
class ProductController(
    private val productServiceUseCase: ProductServiceUseCase
) {

    @PostMapping
    fun createProduct(@RequestBody createProductRequestDto: CreateProductRequestDto): ResponseEntity<BaseResponse<ProductModel>> {
        val product = Product().apply {
            productName = createProductRequestDto.productName
            productPrice = createProductRequestDto.productPrice.toLong()
            productDescription = createProductRequestDto.productDescription
        }
        return RestResponse(productServiceUseCase.createProduct(product)).toResponseEntity()
    }
}