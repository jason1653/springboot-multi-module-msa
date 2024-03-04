package io.jason.bootbase.adapter.persistence.repository

import io.jason.bootbase.adapter.persistence.entity.Payment
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PaymentRepository : JpaRepository<Payment, String> {}