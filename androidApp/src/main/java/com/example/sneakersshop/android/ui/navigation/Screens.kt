package com.example.sneakersshop.android.ui.navigation

sealed class Screens(val route:String) {
    object Home:Screens("home_screen")
}