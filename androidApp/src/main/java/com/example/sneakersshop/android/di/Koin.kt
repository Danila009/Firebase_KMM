package com.example.sneakersshop.android.di

import com.example.sneakersshop.viewModels.sneakersViewModel.SneakersViewModel
import com.example.sneakersshop.viewModels.sneakerInfoViewModel.SneakerInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SneakersViewModel)
    viewModelOf(::SneakerInfoViewModel)
}