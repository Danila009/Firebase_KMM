package com.example.sneakersshop.android.ui.navigation

const val SNEAKER_ID_ARGUMENT = "id"

sealed class Screens(val route:String) {
    object Home:Screens("home_screen")
    object SneakerInfo:Screens("sneaker_info_screen/{id}"){
        fun argument(idSneaker:String):String = "sneaker_info_screen/$idSneaker"
    }
}