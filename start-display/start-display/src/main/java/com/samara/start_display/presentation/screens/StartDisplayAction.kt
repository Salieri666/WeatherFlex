package com.samara.start_display.presentation.screens

import com.samara.core.presentation.base.Action

sealed interface StartDisplayAction : Action {
    object LoadNewTitle: StartDisplayAction
}