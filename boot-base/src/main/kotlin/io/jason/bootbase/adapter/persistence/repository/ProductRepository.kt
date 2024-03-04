package io.jason.bootbase.adapter.persistence.repository

import io.jason.bootbase.adapter.persistence.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface ProductRepository : JpaRepository<Product, String> {
}