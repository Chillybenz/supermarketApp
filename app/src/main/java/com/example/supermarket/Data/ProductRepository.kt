package com.example.supermarket.Data

import com.example.supermarket.Data.Product
import com.example.supermarket.Data.ProductCategory
import kotlinx.coroutines.flow.Flow

class ProductRepository(private val db: AppDatabase) {

    fun getAllCategories(): Flow<List<ProductCategory>> {
        return db.categoryDao().getAll()
    }

    suspend fun insertCategory(category: ProductCategory) {
        db.categoryDao().insert(category)
    }

    suspend fun insertProduct(product: Product) {
        db.productDao().insert(product)
    }
}
