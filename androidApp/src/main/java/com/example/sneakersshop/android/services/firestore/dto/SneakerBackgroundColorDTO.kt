package com.example.sneakersshop.android.services.firestore.dto

import com.example.sneakersshop.android.services.firestore.common.SneakerBackground
import com.example.sneakersshop.services.firestore.dto.SneakerBrandDTO
import com.example.sneakersshop.services.firestore.dto.SneakerColorItemDTO

data class SneakerBackgroundColorDTO (
    val id:String,
    val title:String,
    val promo:String,
    val backgroundColor: SneakerBackground,
    val brand: SneakerBrandDTO,
    val colors:List<SneakerColorItemDTO>
)