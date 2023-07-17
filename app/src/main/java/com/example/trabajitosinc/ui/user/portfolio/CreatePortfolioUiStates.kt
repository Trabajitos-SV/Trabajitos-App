package com.example.trabajitosinc.ui.user.portfolio

sealed class CreatePortfolioUiStates {

    object Resume : CreatePortfolioUiStates()

    data class ErrorWithMessage(val message: String) : CreatePortfolioUiStates()

    data class Error(val exception: Exception) : CreatePortfolioUiStates()

    object Success : CreatePortfolioUiStates()
}