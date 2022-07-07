package com.example.sneakersshop.viewModels.sneakerInfoViewModel

import com.example.sneakersshop.services.firestore.dto.SneakerDTO
import com.example.sneakersshop.services.firestore.useCase.GetSneakerByIdUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.*

class SneakerInfoViewModel(
    private val getSneakerByIdUseCase: GetSneakerByIdUseCase
) : ViewModel() {

    private val _responseSneaker:MutableStateFlow<SneakerDTO?> = MutableStateFlow(null)
    val responseSneaker = _responseSneaker.asStateFlow().filterNotNull()

    fun getSneakerById(id:String){
        getSneakerByIdUseCase.invoke(id).onEach {
            _responseSneaker.value = it
        }.launchIn(viewModelScope)
    }
}