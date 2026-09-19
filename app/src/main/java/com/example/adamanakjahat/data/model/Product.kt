package com.example.adamanakjahat.data.model

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val categoryId: Int,
    @DrawableRes val imageRes: Int
)
