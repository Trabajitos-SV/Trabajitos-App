package com.example.trabajitosinc

import android.app.Application
import com.example.trabajitosinc.data.categories
import com.example.trabajitosinc.repositories.CategoryRepository

class TrabajitosApplication: Application() {
    val categoryRepository: CategoryRepository by lazy {
        CategoryRepository(categories)
    }
}

