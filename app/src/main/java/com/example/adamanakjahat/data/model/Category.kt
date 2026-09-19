package com.example.adamanakjahat.data.model

import androidx.annotation.DrawableRes

data class Category(
    val id: Int,
    val name: String,
    @DrawableRes val iconRes: Int
)
