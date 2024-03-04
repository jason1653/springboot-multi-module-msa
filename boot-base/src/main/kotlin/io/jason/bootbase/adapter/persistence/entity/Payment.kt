package io.jason.bootbase.adapter.persistence.entity

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
    @JoinColumn(name = "PRODUCT_ID")
    val productId: Product? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UID")
    val uid: User? = null,

    @Column(name = "PAYMENT_AMOUNT")
    val paymentAmount: Double = 0.0
)
