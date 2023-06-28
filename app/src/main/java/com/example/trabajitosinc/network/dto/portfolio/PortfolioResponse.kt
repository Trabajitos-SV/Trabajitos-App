package com.example.trabajitosinc.network.dto.portfolio

import com.example.trabajitosinc.data.models.ReviewsModel
import com.example.trabajitosinc.data.models.UserModel
import com.google.gson.annotations.SerializedName

data class PortfolioResponse (
    @SerializedName("_id") val id : String,
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String,
)

// Para el metodo findById y findAll es la misma ruta, solo cambia el metodo
// Falta crear el metodo Create, delete, update Portfolio
// Falta crear la Review metodo Create.


//Find my Portfolio
data class FindMyPortfolioResponse (
    @SerializedName("_id") val id: String,
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String,
    val reviews: List<ReviewsModel>
)

//FindById Portfolio
data class FindByIdPortfolioResponse (
    @SerializedName("_id") val id: String,
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String
)

//Find All Portfolio
data class FindAllPortfolioResponse (
    @SerializedName("_id") val id: String,
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String,
    val reviews: List<ReviewsModel>
)

//Create Portfolio
data class CreatePortfolioResponse(
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String,
    val reviews: List<ReviewsModel>
)

//Delete Portfolio *FALTA HACERLO*
data class DeletePortfolioResponse(
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String,
    val reviews: List<ReviewsModel>
)


//Update Portfolio
data class UpdatePortfolioResponse(
    val title : String,
    val description : String,
    val images : String,
    val user: List<UserModel>,
    val category: String,
    val reviews: List<ReviewsModel>
)

//Create Review
data class CreateReviewResponse(
    val description: String,
    val qualification: Int,
    @SerializedName("id_user") val userRequest: List<UserModel>,
    val default: Boolean,
    @SerializedName("_id") val userHired: List<UserModel>

)