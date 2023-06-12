package com.example.trabajitosinc

import android.app.Application
import com.example.trabajitosinc.data.categories
import com.example.trabajitosinc.data.trabajitos
import com.example.trabajitosinc.repositories.CategoryRepository
import com.example.trabajitosinc.repositories.HistoryRepository

class TrabajitosApplication: Application() {
    val categoryRepository: CategoryRepository by lazy {
        CategoryRepository(categories)
    }

    val historyRepository: HistoryRepository by lazy {
        HistoryRepository(trabajitos)
    }
}

