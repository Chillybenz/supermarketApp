package com.example.supermarket.Data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product: Product)

    @Query("SELECT * FROM products")
    fun getAll(): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE categoryId = :categoryId")
    fun getByCategory(categoryId: Int): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE name LIKE '%' || :query || '%'")
    fun searchByName(query: String): Flow<List<Product>>

    @Query("SELECT * FROM products WHERE price <= :maxPrice")
    fun filterByPrice(maxPrice: Double): Flow<List<Product>>
}
