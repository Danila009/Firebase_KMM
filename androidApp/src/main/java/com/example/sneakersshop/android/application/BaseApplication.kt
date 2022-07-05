package com.example.sneakersshop.android.application

import android.app.Application
import com.example.sneakersshop.android.di.viewModelModule
import com.example.sneakersshop.di.initKoin
import org.koin.android.ext.koin.androidContext

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@BaseApplication)

            modules(
                viewModelModule
            )
        }
    }
}