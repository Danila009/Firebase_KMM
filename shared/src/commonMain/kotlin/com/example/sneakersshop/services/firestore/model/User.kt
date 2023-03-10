package com.example.sneakersshop.services.firestore.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id:String,
    val username:String,
    val email:String,
    val phone:String
)