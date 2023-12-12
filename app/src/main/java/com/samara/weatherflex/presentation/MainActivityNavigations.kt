package com.samara.weatherflex.presentation

import androidx.navigation.NavGraphBuilder
import com.samara.core.di.base.ComponentManagerLifecycle
import com.samara.core.presentation.navigation.INavigation
import com.samara.start_display.presentation.navigation.rememberStartDisplayNavigation
import com.samara.start_display.presentation.navigation.startScreenBuilderGraph


fun NavGraphBuilder.mainActivityNavigationGraph(
    baseNavigation: INavigation
) {
    startScreenBuilderGraph(
        getStartDisplayNavigation = { rememberStartDisplayNavigation(baseNavigation) },
        componentLifecycleBefore = { ComponentManagerLifecycle(it) }
    )
    //screenfeature2
    //screenfeature3
}