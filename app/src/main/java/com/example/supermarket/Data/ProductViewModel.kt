package com.example.supermarket.Data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.supermarket.Data.ProductCategory
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull

class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ProductRepository(AppDatabase.getInstance(application))

    init {
        insertInitialCategories()
    }

    private fun insertInitialCategories() {
        viewModelScope.launch {
            val existing = repository.getAllCategories().firstOrNull() ?: emptyList()
            if (existing.isEmpty()) {
                val categories = listOf(
                    ProductCategory(name = "Φρέσκα Τρόφιμα", imageUrl = "freshfood"),
                    ProductCategory(name = "Γαλακτοκομικά", imageUrl = "dairy"),
                    ProductCategory(name = "Κατεψυγμένα", imageUrl = "freezer"),
                    ProductCategory(name = "Καθαριστικά", imageUrl = "cleaner")
                )
                categories.forEach { repository.insertCategory(it) }
            }
        }
    }

    fun getAllCategories(): Flow<List<ProductCategory>> {
        return AppDatabase.getInstance(getApplication()).categoryDao().getAll()
    }

}
