package com.example.sneakersshop.services.firestore.model

import kotlinx.serialization.Serializable

@Serializable
data class Brand(
    val id:String,
    val title:String,
    val sneakers:List<BrandSneakersItem>
)

@Serializable
data class BrandSneakersItem(
    val sneakerId: String
)