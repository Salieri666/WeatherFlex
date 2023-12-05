package com.samara.start_display.presentation.navigation

import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.samara.start_display.presentation.screens.StartDisplayScreen

fun NavGraphBuilder.startScreenBuilderGraph() {
    composable(StartScreenDestination.route) { navEntry: NavBackStackEntry ->
        StartDisplayScreen()
    }
}
