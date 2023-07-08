package com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId

import com.google.gson.annotations.SerializedName

data class FindPortfolioByCategoryIdRequest (
    @SerializedName("identifier") val idCategory: String
    )