package io.jason.bootproduct.adapter.out.persisence.repository

import io.jason.bootproduct.adapter.out.persisence.entity.Product
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository


@Repository
interface ProductRepository : MongoRepository<Product, String> {
}