package com.example.trabajitosinc

import android.app.Application
import com.example.trabajitosinc.data.categories

import com.example.trabajitosinc.data.users
import com.example.trabajitosinc.repositories.CategoryRepository
import com.example.trabajitosinc.repositories.UserRepository
import com.example.trabajitosinc.data.trabajitos
import com.example.trabajitosinc.repositories.HistoryRepository

class TrabajitosApplication: Application() {

    val categoryRepository: CategoryRepository by lazy {
        CategoryRepository(categories)
    }


    val userRepository: UserRepository by lazy {
        UserRepository(users)
    }

    val historyRepository: HistoryRepository by lazy {
        HistoryRepository(trabajitos)

    }
}

