package io.jason.bootproduct.adapter.persisence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collation = "PRODUCT")
class Product {
    @Id
    var productId: String = ""
    val productName: String = ""
    val productPrice: Double = 0.0
    val productDescription: String = ""
}