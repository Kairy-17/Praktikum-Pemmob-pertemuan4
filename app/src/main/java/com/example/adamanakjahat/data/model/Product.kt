package com.example.adamanakjahat.data.model

import androidx.annotation.DrawableRes

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val categoryId: Int,
    @DrawableRes val imageRes: Int,
    val price: Int = 15000,
    val stock: Int = 10,
    val img: String = "dummy_product"
)
