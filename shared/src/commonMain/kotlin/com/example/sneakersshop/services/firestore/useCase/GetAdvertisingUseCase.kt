package com.example.sneakersshop.services.firestore.useCase

import com.example.sneakersshop.services.firestore.model.Advertising
import com.example.sneakersshop.services.firestore.repository.FirestoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAdvertisingUseCase(
    private val firestoreRepository: FirestoreRepository
) {
    operator fun invoke():Flow<List<Advertising>> = flow {
        emit(firestoreRepository.getAdvertising())
    }
}