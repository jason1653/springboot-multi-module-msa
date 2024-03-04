package io.jason.bootbase.adapter.persistence.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.Columns

@Entity
@Table(name = "PRODUCT")
data class Product(
    @Id
    @Column(name = "PRODUCT_ID", length = 20)
    var productId: String = "",

    @Column(name = "PRODUCT_NAME", length = 100)
    var productName: String = "",

    @Column(name = "PRODUCT_PRICE")
    var productPrice: Double = 0.0


) {
}