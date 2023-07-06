package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.data.models.PortfolioModel
import com.example.trabajitosinc.data.models.PortfolioModel2



class PortfolioRepository (private val portfolios: MutableList<PortfolioModel> ) {

    fun getPortfolios()= portfolios

}