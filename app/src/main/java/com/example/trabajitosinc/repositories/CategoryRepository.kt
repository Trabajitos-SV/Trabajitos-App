package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.data.models.CategoryModel

class CategoryRepository(private val categories: MutableList<CategoryModel>) {
    fun getCategories() = categories
}