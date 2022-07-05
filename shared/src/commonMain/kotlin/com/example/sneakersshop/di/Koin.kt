package com.example.sneakersshop.di

import com.example.sneakersshop.services.firestore.repository.FirestoreRepository
import com.example.sneakersshop.services.firestore.repository.FirestoreRepositoryImpl
import com.example.sneakersshop.services.firestore.useCase.GetSneakersUseCase
import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.firestore.firestore
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(
        firestoreModule,
        repositoryModule,
        useCaseModule
    )
}

// IOS
fun initKoin() = initKoin {}

val firestoreModule = module {
    single { Firebase.firestore }
}

val repositoryModule = module {
    singleOf(::FirestoreRepositoryImpl) bind FirestoreRepository::class
}

val useCaseModule = module {
    factoryOf(::GetSneakersUseCase)
}