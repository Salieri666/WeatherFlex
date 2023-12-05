package com.samara.weatherflex.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.samara.start_display.presentation.navigation.StartScreenDestination
import com.samara.weatherflex.presentation.navigation.mainActivityNavigationGraph

@Composable
fun MainActivityScreen(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = StartScreenDestination.route,
        builder = {
            mainActivityNavigationGraph(navController)
        }
    )
}