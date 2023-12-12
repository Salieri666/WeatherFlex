package com.samara.start_display.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import com.samara.core.presentation.navigation.INavigation

interface IStartDisplayNavigation : INavigation {
    fun navigateToStartDisplay()
}

@Stable
class StartDisplayNavigation(basicNavigation: INavigation) : IStartDisplayNavigation, INavigation by basicNavigation {

    override fun navigateToStartDisplay() = navController.navigate(
        StartScreenDestination.route
    )

}

@Composable
fun rememberStartDisplayNavigation(basicNavigation: INavigation): IStartDisplayNavigation = remember(
    basicNavigation
) {
    StartDisplayNavigation(basicNavigation)
}