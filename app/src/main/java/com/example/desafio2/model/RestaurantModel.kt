package com.example.desafio2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RestaurantModel(
        val id: Int,
        val firstImage: String,
        val restaurantName: String,
        val restaurantPlace: String,
        val restaurantHour: String,
        val listPlates: MutableList<PlatesModel>
        ) : Parcelable