package com.example.trabajitosinc.ui.user.FindAllPorCategoryId

sealed class FindAllCategoryIdUiStates {

        object Resume : FindAllCategoryIdUiStates()

        class Error(val exception: Exception) : FindAllCategoryIdUiStates()

        data class ErrorWithMessage(val message: String) : FindAllCategoryIdUiStates()

        object Success : FindAllCategoryIdUiStates()
}