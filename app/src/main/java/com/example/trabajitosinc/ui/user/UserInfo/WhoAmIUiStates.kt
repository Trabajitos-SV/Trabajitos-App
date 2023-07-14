package com.example.trabajitosinc.ui.user.UserInfo

sealed class WhoAmIUiStates {

        object Resume : WhoAmIUiStates()

        class Error(val exception: Exception) : WhoAmIUiStates()

        data class ErrorWithMessage(val message: String) : WhoAmIUiStates()

        object Success : WhoAmIUiStates()
}