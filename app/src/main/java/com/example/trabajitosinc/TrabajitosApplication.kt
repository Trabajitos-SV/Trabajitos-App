package com.example.trabajitosinc

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.trabajitosinc.data.categories
import com.example.trabajitosinc.data.complexUsers
import com.example.trabajitosinc.data.porfolios
import com.example.trabajitosinc.data.users
import com.example.trabajitosinc.repositories.UserRepository
import com.example.trabajitosinc.data.trabajitos
import com.example.trabajitosinc.network.retrofit.RetrofitInstance
import com.example.trabajitosinc.network.retrofit.RetrofitInstance.setToken
import com.example.trabajitosinc.repositories.CategoryRepository
import com.example.trabajitosinc.repositories.HistoryRepository
import com.example.trabajitosinc.repositories.PortfolioRepository
import com.example.trabajitosinc.repositories.UserComplexRepository
import com.example.trabajitosinc.repository.CredentialsRepository
import com.example.trabajitosinc.repository.PortfolioCRepository

class TrabajitosApplication: Application() {

    val portfolioRepository : PortfolioRepository by lazy {
        PortfolioRepository(porfolios)
    }

    val categoryRepository: CategoryRepository by lazy {
        CategoryRepository(categories)
    }

    val userComplexRepository: UserComplexRepository by lazy {
        UserComplexRepository(complexUsers)
    }

    val userRepository: UserRepository by lazy {
        UserRepository(users)
    }

    val historyRepository: HistoryRepository by lazy {
        HistoryRepository(trabajitos)

    }

    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }


    //FactoryKey para Login y Register con token
    private fun getAPIService() = with(RetrofitInstance){
        setToken(getToken())
        getLoginService()
    }
    fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }


    //Factory Key para Portfolio con token
    private fun getAPIServicePortfolio() = with(RetrofitInstance){
        setToken(getToken())
        getPortfolioService()
    }
    val portfolioCRepository: PortfolioCRepository by lazy {
        PortfolioCRepository(getAPIServicePortfolio())
    }




    fun saveAuthToken(token: String){
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }
    companion object {
        const val USER_TOKEN = "user_token"
    }

}

