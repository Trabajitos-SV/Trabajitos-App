package com.example.trabajitosinc.repositories

import com.example.trabajitosinc.data.models.PortfolioModel


class PortfolioRepository (private val portfolios: MutableList<PortfolioModel> ) {

    fun getPortfolios()= portfolios

}