package com.example.supermarket.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class ProductCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val imageUrl: String
)
