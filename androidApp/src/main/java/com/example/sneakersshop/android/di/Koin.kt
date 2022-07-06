package com.example.sneakersshop.android.di

import com.example.sneakersshop.viewModels.sneakersViewModel.SneakersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SneakersViewModel)
}