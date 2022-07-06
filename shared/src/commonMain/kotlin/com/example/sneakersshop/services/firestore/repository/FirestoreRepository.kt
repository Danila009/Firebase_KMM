package com.example.sneakersshop.services.firestore.repository

import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.model.Advertising
import com.example.sneakersshop.services.firestore.model.Brand
import com.example.sneakersshop.services.firestore.model.SneakerColor

interface FirestoreRepository {

    suspend fun getSneakers():List<SneakerDTO>

    suspend fun getBrandById(id:String):Brand

    suspend fun getSneakerColorById(id:String):SneakerColor

    suspend fun getAdvertising():List<Advertising>
}