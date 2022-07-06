package com.example.sneakersshop.android.services.firestore.extensions

import com.example.sneakersshop.android.services.firestore.common.SneakerBackground
import com.example.sneakersshop.android.services.firestore.dto.SneakerBackgroundColorDTO
import com.example.sneakersshop.services.firestore.dto.SneakerDTO

fun SneakerDTO.mapSneakerBackgroundColor() : SneakerBackgroundColorDTO {
    return SneakerBackgroundColorDTO(
        id = id,
        title = title,
        promo = promo,
        backgroundColor = enumValueOf(backgroundColor),
        brand = brand,
        colors = colors
    )
}