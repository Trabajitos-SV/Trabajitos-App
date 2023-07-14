package com.example.trabajitosinc.network.dto.portfolio.findPortfolioByCategoryId.listFindCById

import android.os.Parcelable
import com.example.trabajitosinc.data.models.CategoryModel
import com.example.trabajitosinc.data.models.ImageModel
import com.example.trabajitosinc.data.models.UserModel
import com.example.trabajitosinc.network.dto.portfolio.Review.ReviewResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FindPortfolioByCategoryIdLitst (
    val _id: String,
    val title: String,
    val description: String,
    val uploadedImages: List<ImageModel>,
    val user: UserModel,
    val category: CategoryModel,
    val reviews: List<ReviewResponse> = emptyList()
):Parcelable {
    init {
        user.image ?: "https://cdn.autobild.es/sites/navi.axelspringer.es/public/media/image/2016/09/569465-whatsapp-que-tus-contactos-ponen-rana-perfil.jpg?tf=3840x"
    }
}