package com.example.sneakersshop.services.firestore.model

data class Brand(
    val id:String,
    val title:String,
    val sneakers:List<BrandSneakersItem>
)

data class BrandSneakersItem(
    val sneakerId: String
)