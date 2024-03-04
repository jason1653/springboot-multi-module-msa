package io.jason.bootproduct.adapter.persisence.repository

import io.jason.bootproduct.adapter.persisence.entity.ProductEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<ProductEntity, String> {
}