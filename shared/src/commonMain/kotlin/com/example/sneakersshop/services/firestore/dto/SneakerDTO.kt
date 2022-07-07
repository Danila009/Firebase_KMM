package com.example.sneakersshop.services.firestore.dto

import com.example.sneakersshop.services.firestore.model.SneakerShoeSize

data class SneakerDTO(
    val id:String,
    val title:String,
    val promo:String,
    val backgroundColor:String,
    val brand: SneakerBrandDTO,
    val colors:List<SneakerColorItemDTO>
)

data class SneakerBrandDTO(
    val id:String,
    val title: String
)

data class SneakerColorItemDTO(
    val id:String,
    val name:String,
    val icons:List<String>,
    val shoeSize:List<SneakerShoeSizeDTO>
)

data class SneakerShoeSizeDTO(
    val size:String
)