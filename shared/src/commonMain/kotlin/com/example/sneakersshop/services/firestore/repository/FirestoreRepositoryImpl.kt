package com.example.sneakersshop.services.firestore.repository

import com.example.sneakersshop.services.firestore.model.Sneaker
import dev.gitlive.firebase.firestore.FirebaseFirestore

class FirestoreRepositoryImpl(
    private val db:FirebaseFirestore
) : FirestoreRepository {

    override suspend fun getSneakers(): List<Sneaker> {

        return db.collection(SNEAKERS_COLLECTION_KEY)
            .get()
            .documents
            .map { it.data() }
    }

    companion object {

        const val SNEAKERS_COLLECTION_KEY = "sneakers"
    }
}