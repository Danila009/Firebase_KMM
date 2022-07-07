package com.example.sneakersshop.services.firestore.repository

import com.example.sneakersshop.services.firestore.dto.SneakerBrandDTO
import com.example.sneakersshop.services.firestore.dto.SneakerColorItemDTO
import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.dto.SneakerShoeSizeDTO
import com.example.sneakersshop.services.firestore.model.*
import dev.gitlive.firebase.firestore.*

class FirestoreRepositoryImpl(
    private val db:FirebaseFirestore
) : FirestoreRepository {

    override suspend fun getSneakers(search:String): List<SneakerDTO> {
        val sneaker = db.collection(SNEAKERS_COLLECTION_KEY)
            .orderBy("title")
            .startAt(search)
            .endAt("$search~")
            .get()
            .documents
            .map { it.data<Sneaker>() }

        return sneaker.map { it.mapDTO() }
    }

    override suspend fun getSneakerById(id: String): SneakerDTO {
        val sneaker = db.collection(SNEAKERS_COLLECTION_KEY)
            .document(id)
            .get()
            .data<Sneaker>()

        return sneaker.mapDTO()
    }

    private suspend fun Sneaker.mapDTO():SneakerDTO{
        val brand = getBrandById(this.brand.idBrand)
        return SneakerDTO(
            id = this.id,
            title = this.title,
            promo = this.promo,
            backgroundColor = this.backgroundColor,
            brand = SneakerBrandDTO(
                id = this.brand.idBrand,
                title = brand.title
            ),
            colors = this.colors.map { color ->
                val sneakerColor = getSneakerColorById(color.colorId)
                SneakerColorItemDTO(
                    id = color.colorId,
                    name = sneakerColor.name,
                    icons = sneakerColor.icons,
                    shoeSize = emptyList()
//                    sneakerColor.shoeSize.map {
//                        val shoeSize = getShoeSizeById(it.shoeSizeId)
//                        SneakerShoeSizeDTO(
//                            size = shoeSize.size
//                        )
//                    }
                )
            }
        )
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

    override suspend fun getShoeSizeById(id: String): SneakerShoeSize {
        return db.collection(SNEAKERS_SHOE_SIZE_COLLECTION_KEY)
            .document(id)
            .get()
            .data()
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