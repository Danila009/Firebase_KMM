package com.example.sneakersshop.services.firestore.repository

import com.example.sneakersshop.services.firestore.dto.SneakerBrandDTO
import com.example.sneakersshop.services.firestore.dto.SneakerColorItemDTO
import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.model.Advertising
import com.example.sneakersshop.services.firestore.model.Brand
import com.example.sneakersshop.services.firestore.model.Sneaker
import com.example.sneakersshop.services.firestore.model.SneakerColor
import dev.gitlive.firebase.firestore.FirebaseFirestore

class FirestoreRepositoryImpl(
    private val db:FirebaseFirestore
) : FirestoreRepository {

    override suspend fun getSneakers(): List<SneakerDTO> {
        val sneaker = db.collection(SNEAKERS_COLLECTION_KEY)
            .get()
            .documents
            .map { it.data<Sneaker>() }

        return sneaker.map {
            val brand = getBrandById(it.brand.idBrand)
            SneakerDTO(
                id = it.id,
                title = it.title,
                promo = it.promo,
                backgroundColor = it.backgroundColor,
                brand = SneakerBrandDTO(
                    id = it.brand.idBrand,
                    title = brand.title
                ),
                colors = it.colors.map { color ->
                    val sneakerColor = getSneakerColorById(color.colorId)
                    SneakerColorItemDTO(
                        id = color.colorId,
                        name = sneakerColor.name
                    )
                }
            )
        }
    }

    override suspend fun getBrandById(id: String): Brand {
        return db.collection(BRANDS_COLLECTION_KEY)
            .document(id)
            .get()
            .data()
    }

    override suspend fun getSneakerColorById(id: String): SneakerColor {
        return db.collection(SNEAKERS_COLORS_COLLECTION_KEY)
            .document(id)
            .get()
            .data()
    }

    override suspend fun getAdvertising(): List<Advertising> {
        return db.collection(ADVERTISING_COLLECTION_KEY)
            .get()
            .documents
            .map { it.data() }
    }

    companion object {

        const val SNEAKERS_COLLECTION_KEY = "sneakers"
        const val BRANDS_COLLECTION_KEY = "brands"
        const val SNEAKERS_COLORS_COLLECTION_KEY = "sneakers_colors"
        const val ADVERTISING_COLLECTION_KEY = "advertising"
        const val SNEAKERS_SHOE_SIZE_COLLECTION_KEY = "sneakers_shoe_size"
        const val USERS_COLLECTION_KEY = "users"
    }
}