package com.example.sneakersshop.services.firestore.model

import kotlinx.serialization.Serializable

@Serializable
data class SneakerColor(
    val id:String,
    val name:String,
    val idSneaker:String,
    val icons:List<String>,
    val shoeSize:List<SneakerColorShoeSizeItem>
)

@Serializable
data class SneakerColorShoeSizeItem(
    val shoeSizeId:String,
    val price:Int
)