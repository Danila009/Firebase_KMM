package com.example.sneakersshop.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.sneakersshop.android.ui.navigation.host.BaseNavHost
import com.example.sneakersshop.android.ui.theme.SneakersShopTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { SneakersShopTheme { BaseNavHost() } }
    }
}
