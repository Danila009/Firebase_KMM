package com.example.sneakersshop.services.firestore.model

import kotlinx.serialization.Serializable

@Serializable
data class SneakerShoeSize(
    val id:String,
    val size:String
)