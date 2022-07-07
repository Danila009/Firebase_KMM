package com.example.sneakersshop.services.firestore.repository

import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.model.Advertising
import com.example.sneakersshop.services.firestore.model.Brand
import com.example.sneakersshop.services.firestore.model.SneakerColor
import com.example.sneakersshop.services.firestore.model.SneakerShoeSize

interface FirestoreRepository {

    suspend fun getSneakers(search:String):List<SneakerDTO>

    suspend fun getSneakerById(id:String):SneakerDTO

    suspend fun getBrandById(id:String):Brand

    suspend fun getSneakerColorById(id:String):SneakerColor

    suspend fun getAdvertising():List<Advertising>

    suspend fun getShoeSizeById(id:String):SneakerShoeSize
}