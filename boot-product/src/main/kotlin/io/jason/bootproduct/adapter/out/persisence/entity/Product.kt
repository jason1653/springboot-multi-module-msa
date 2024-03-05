package io.jason.bootproduct.adapter.out.persisence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document


@Document(collation = "PRODUCT")
class Product {
    @Id
    var productId: String = ""
    var productName: String = ""
    var productPrice: Long = 0
    var productDescription: String = ""
}