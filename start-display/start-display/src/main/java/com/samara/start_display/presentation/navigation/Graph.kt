package com.samara.start_display.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.samara.core.extensions.getVm
import com.samara.core.presentation.navigation.Destination
import com.samara.start_display.di.StartDisplayComponentHolder
import com.samara.start_display.presentation.screens.StartDisplayScreen

fun NavGraphBuilder.startScreenBuilderGraph(
    getStartDisplayNavigation: @Composable () -> IStartDisplayNavigation,
    componentLifecycleBefore: @Composable (NavBackStackEntry.(Destination) -> Unit)
) {
    composable(StartScreenDestination.route) { navEntry: NavBackStackEntry ->
        navEntry.componentLifecycleBefore(StartScreenDestination)
        StartDisplayScreen(
            startDisplayNavigation = getStartDisplayNavigation(),
            vm = navEntry.getVm(StartDisplayComponentHolder.get().getVmFactory())
        )
    }
}
