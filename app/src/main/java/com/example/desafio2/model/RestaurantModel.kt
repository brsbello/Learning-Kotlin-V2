package com.example.desafio2.model

data class RestaurantModel(
        val id: Int,
        val firstImage: String,
        val restaurantName: String,
        val restaurantPlace: String,
        val restaurantHour: String,
        val listPlates: MutableList<PlatesModel>
        )