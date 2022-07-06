package com.example.sneakersshop.services.firestore.model

import kotlinx.serialization.Serializable

@Serializable
data class Advertising(
    val previews:String,
    val sneakerId:String
)