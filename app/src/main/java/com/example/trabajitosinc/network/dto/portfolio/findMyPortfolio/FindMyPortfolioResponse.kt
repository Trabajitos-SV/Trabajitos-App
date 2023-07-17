package com.example.trabajitosinc.network.dto.portfolio.findMyPortfolio
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.ImageModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewResponse
import com.google.gson.annotations.SerializedName

data class FindMyPortfolioResponse (
    val _id: String,
    val title: String,
    val description: String,
    val images: List<ImageModel>,
    val user: UserModel,
    val category: CategoryModel,
    @SerializedName("avgQualification") val qualification: Double,
    val reviews: List<ReviewResponse> = emptyList()
)