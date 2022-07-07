package com.example.sneakersshop.android.ui.navigation.host

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sneakersshop.android.ui.icon.NiaIcons
import com.example.sneakersshop.android.ui.navigation.SNEAKER_ID_ARGUMENT
import com.example.sneakersshop.android.ui.navigation.Screens
import com.example.sneakersshop.android.ui.screens.home.HomeScreen
import com.example.sneakersshop.android.ui.screens.sneakerInfo.SneakerInfoScreen
import com.example.sneakersshop.android.ui.theme.primaryBackground
import com.example.sneakersshop.android.ui.theme.secondaryBackground
import com.example.sneakersshop.android.ui.theme.primaryText

private enum class BottomBarData(
    val title:String,
    val image:ImageVector
) {
    SEARCH(title = "Search", image = NiaIcons.search),
    BASKET(title = "Basket", image = NiaIcons.basket),
    HOME(title = "Home", image = NiaIcons.home),
    FAVORITE(title = "Favorite", image = NiaIcons.favorite),
    PROFILE(title = "Profile", image = NiaIcons.profile)
}

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun BaseNavHost() {
    val navHostController = rememberNavController()

    var bottomBarDataItem by rememberSaveable { mutableStateOf(BottomBarData.HOME) }

    LaunchedEffect(
        key1 = bottomBarDataItem,
        block = {
            when(bottomBarDataItem){
                BottomBarData.SEARCH -> {

                }
                BottomBarData.BASKET -> {

                }
                BottomBarData.FAVORITE -> {

                }
                BottomBarData.PROFILE -> {

                }
                BottomBarData.HOME -> {
                    navHostController.navigate(Screens.Home.route)
                }
            }
        }
    )

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    bottomBarDataItem = BottomBarData.HOME
                },
                shape = RoundedCornerShape(50),
                backgroundColor = secondaryBackground
            ) {
                Icon(
                    NiaIcons.home,
                    tint = if(bottomBarDataItem == BottomBarData.HOME)
                        Color.Black
                    else
                        primaryText,
                    contentDescription = null
                )
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,
        bottomBar = {
            BottomAppBar(
                cutoutShape = RoundedCornerShape(50),
                backgroundColor = secondaryBackground
            ) {
                BottomNavigation(
                    backgroundColor = secondaryBackground
                ) {
                    BottomBarData.values().forEach { item ->
                        BottomNavigationItem(
                            alwaysShowLabel = false,
                            selectedContentColor = Color.Black,
                            unselectedContentColor = primaryText,
                            selected = bottomBarDataItem == item,
                            icon = {
                                Icon(
                                    imageVector = item.image,
                                    contentDescription = null,
                                )
                            },
                            onClick = { bottomBarDataItem = item }
                        )
                    }
                }
            }
        }, content = {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = primaryBackground
            ) {
                NavHost(
                    navController = navHostController,
                    startDestination = Screens.Home.route,
                    builder = {
                        composable(Screens.Home.route){
                            HomeScreen(navController = navHostController)
                        }
                        composable(
                            route = Screens.SneakerInfo.route,
                            arguments = listOf(
                                navArgument(SNEAKER_ID_ARGUMENT){
                                    type = NavType.StringType
                                }
                            )
                        ) {
                            SneakerInfoScreen(
                                navController = navHostController,
                                idSneaker = it.arguments?.getString(SNEAKER_ID_ARGUMENT)!!
                            )
                        }
                    }
                )
            }
        }
    )
}