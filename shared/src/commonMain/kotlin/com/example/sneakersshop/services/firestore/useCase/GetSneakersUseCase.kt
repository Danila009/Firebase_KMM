package com.example.sneakersshop.services.firestore.useCase

import com.example.sneakersshop.services.firestore.model.Sneaker
import com.example.sneakersshop.services.firestore.repository.FirestoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSneakersUseCase(
    private val firestoreRepository: FirestoreRepository
){
    operator fun invoke():Flow<List<Sneaker>> = flow {
        emit( firestoreRepository.getSneakers() )
    }
}