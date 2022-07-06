package com.example.sneakersshop.viewModels.sneakersViewModel

import com.example.sneakersshop.services.firestore.useCase.GetAdvertisingUseCase
import com.example.sneakersshop.services.firestore.useCase.GetSneakersUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class SneakersViewModel(
    getSneakersUseCase: GetSneakersUseCase,
    getAdvertisingUseCase: GetAdvertisingUseCase
) : ViewModel() {

    val responseSneakers = getSneakersUseCase.invoke()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    val responseAdvertising = getAdvertisingUseCase.invoke()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())
}