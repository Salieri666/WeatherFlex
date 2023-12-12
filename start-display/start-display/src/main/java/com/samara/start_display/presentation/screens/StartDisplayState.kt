package com.samara.start_display.presentation.screens

import com.samara.core.presentation.base.State
import kotlinx.parcelize.Parcelize

@Parcelize
data class StartDisplayState(
    val title: String = "Hello world"
) : State
