package io.jason.bootproduct.application.core.usecase

import io.jason.bootproduct.adapter.out.persisence.entity.Product
import io.jason.bootproduct.application.core.domain.ProductModel
import io.jason.bootproduct.application.port.`in`.ProductServiceUseCase
import io.jason.bootproduct.application.port.out.ProductServiceAdapterPort
import io.jason.commonresponse.enums.BaseResponseSuccessEnum
import io.jason.commonresponse.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productServiceAdapterPort: ProductServiceAdapterPort
) : ProductServiceUseCase {
    override fun createProduct(product: Product): BaseResponse<ProductModel> {
        val productModel = productServiceAdapterPort.saveProduct(product)
        return BaseResponse.success(
            BaseResponseSuccessEnum.CREATED,
            productModel
        )
    }
}