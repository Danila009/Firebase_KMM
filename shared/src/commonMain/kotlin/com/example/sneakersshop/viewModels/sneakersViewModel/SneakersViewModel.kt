package com.example.sneakersshop.viewModels.sneakersViewModel

import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.useCase.GetAdvertisingUseCase
import com.example.sneakersshop.services.firestore.useCase.GetSneakersUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.*

class SneakersViewModel(
    private val getSneakersUseCase: GetSneakersUseCase,
    getAdvertisingUseCase: GetAdvertisingUseCase
) : ViewModel() {

    private val _responseSneakers = MutableStateFlow(emptyList<SneakerDTO>())
    val responseSneakers = _responseSneakers.asStateFlow()

    val responseAdvertising = getAdvertisingUseCase.invoke()
        .stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    fun getSneakers(search:String){
        getSneakersUseCase.invoke(search).onEach {
            _responseSneakers.value = it
        }.launchIn(viewModelScope)
    }
}