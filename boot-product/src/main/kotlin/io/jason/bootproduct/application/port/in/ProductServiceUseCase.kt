package io.jason.bootproduct.application.port.`in`

import io.jason.bootproduct.adapter.out.persisence.entity.Product
import io.jason.bootproduct.application.core.domain.ProductModel
import io.jason.commonresponse.response.BaseResponse

interface ProductServiceUseCase {
    fun createProduct(product: Product): BaseResponse<ProductModel>
}