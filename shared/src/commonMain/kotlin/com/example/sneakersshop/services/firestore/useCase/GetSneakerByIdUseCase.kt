package com.example.sneakersshop.services.firestore.useCase

import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.repository.FirestoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetSneakerByIdUseCase(
    private val firestoreRepository: FirestoreRepository
) {
    operator fun invoke(id:String):Flow<SneakerDTO> = flow {
        emit( firestoreRepository.getSneakerById(id) )
    }
}