package com.example.desafio2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlatesModel(
    val id: Int,
    val plateImage: String,
    val plateName: String,
    val plateDescription: String,
    ) : Parcelable