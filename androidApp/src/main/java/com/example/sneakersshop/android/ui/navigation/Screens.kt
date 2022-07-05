package com.example.sneakersshop.android.ui.navigation

sealed class Screens(val route:String) {
    object Sneakers:Screens("sneakers_screen")
}