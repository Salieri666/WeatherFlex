package com.samara.weatherflex.presentation

import com.samara.core.presentation.base.State
import com.samara.start_display.presentation.navigation.StartScreenDestination
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainActivityState(
    val startDestination: String = StartScreenDestination.route,
) : State
