package com.samara.weatherflex.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.samara.core.presentation.navigation.rememberBaseNavigation

@Composable
fun MainActivityScreen(
    navController: NavHostController,
    vm: MainActivityVm
) {
    val state by vm.state.collectAsState();

    val baseNavigation = rememberBaseNavigation(navController)

    NavHost(
        navController = navController,
        startDestination = state.startDestination,
        builder = {
            mainActivityNavigationGraph(baseNavigation)
        }
    )
}