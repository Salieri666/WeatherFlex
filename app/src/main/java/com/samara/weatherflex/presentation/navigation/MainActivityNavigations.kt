package com.samara.weatherflex.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.samara.start_display.presentation.navigation.startScreenBuilderGraph

fun NavGraphBuilder.mainActivityNavigationGraph(
    mainController: NavHostController
) {
    startScreenBuilderGraph()
}