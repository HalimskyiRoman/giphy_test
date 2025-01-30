package com.opinc.giphy_wwl.presentation.navigation

sealed class Screen(
    val route: String,
) {
    object MainScreen : Screen("main_screen")
    object FullScreen : Screen("full_screen")
}