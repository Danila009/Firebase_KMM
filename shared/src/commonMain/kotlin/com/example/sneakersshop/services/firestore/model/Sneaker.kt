package com.example.sneakersshop.services.firestore.model

import kotlinx.serialization.Serializable

@Serializable
data class Sneaker(
    val id:String,
    val title:String,
    val promo:String,
    val backgroundColor:String,
    val brand:SneakerBrand,
    val colors:List<SneakerColorItem>
)

@Serializable
data class SneakerBrand(
    val idBrand:String
)

@Serializable
data class SneakerColorItem(
    val colorId:String
)