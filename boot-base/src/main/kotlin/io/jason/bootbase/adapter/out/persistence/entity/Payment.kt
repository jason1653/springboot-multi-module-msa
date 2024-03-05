package io.jason.bootbase.adapter.out.persistence.entity

import jakarta.persistence.*
import org.hibernate.annotations.GeneratedColumn

@Entity
@Table(name = "PAYMENT")
data class Payment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAYMENT_ID")
    val paymentId: Long = 0L,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    val uid: User? = null,

    @Column(name = "PRODUCT_ID")
    val productId: String = "",


    @Column(name = "PRODUCT_NAME")
    val productName: String = "",

    @Column(name = "PAYMENT_AMOUNT")
    val paymentAmount: Double = 0.0
)
