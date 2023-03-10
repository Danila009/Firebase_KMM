package com.example.sneakersshop.services.firestore.useCase

import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.repository.FirestoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSneakersUseCase(
    private val firestoreRepository: FirestoreRepository
){
    operator fun invoke(search:String):Flow<List<SneakerDTO>> = flow {
        emit( firestoreRepository.getSneakers(search) )
    }
}