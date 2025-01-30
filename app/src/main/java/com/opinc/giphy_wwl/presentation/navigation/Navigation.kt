package com.opinc.giphy_wwl.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.opinc.giphy_wwl.presentation.screens.FullScreen
import com.opinc.giphy_wwl.presentation.screens.MainScreen
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Navigation(
) {

    val navController = rememberNavController()



    Scaffold(
        modifier = Modifier
    ) { innerPadding ->
        NavHost(
            navController,
            startDestination = "main",
            Modifier
                .padding(
                    PaddingValues(
                        top = 0.dp, bottom = innerPadding.calculateBottomPadding()
                    )
                )
                .fillMaxSize(1f)
        ) {
            navigation(
                startDestination = Screen.MainScreen.route, route = "main"
            ) {
                composable(route = Screen.MainScreen.route) { entry ->
                    MainScreen { url ->
                        val encodedUrl = URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
                        navController.navigate("${Screen.FullScreen.route}/$encodedUrl")
                    }
                }
                composable(route = "${Screen.FullScreen.route}/{url}") { entry ->
                    val url = entry.arguments?.getString("url")?.let {
                        URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
                    } ?: ""
                    FullScreen(url = url)
                }
            }
        }
    }
}