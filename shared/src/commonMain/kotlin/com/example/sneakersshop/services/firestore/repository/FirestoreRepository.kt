package com.example.sneakersshop.services.firestore.repository

import com.example.sneakersshop.services.firestore.model.Sneaker

interface FirestoreRepository {

    suspend fun getSneakers():List<Sneaker>

}