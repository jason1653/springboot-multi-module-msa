package io.jason.bootbase.adapter.out.persistence.repository

import io.jason.bootbase.adapter.out.persistence.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
@Repository
interface ProductRepository : JpaRepository<Product, String> {
}