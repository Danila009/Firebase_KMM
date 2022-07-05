package com.example.sneakersshop.android.ui.navigation.host

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sneakersshop.android.ui.navigation.Screens
import com.example.sneakersshop.android.ui.screens.sneakers.SneakersScreen

@Composable
fun BaseNavHost() {
    val navHostController = rememberNavController()

    NavHost(
        navController = navHostController,
        startDestination = Screens.Sneakers.route,
        builder = {
            composable(Screens.Sneakers.route){
                SneakersScreen()
            }
        }
    )
}