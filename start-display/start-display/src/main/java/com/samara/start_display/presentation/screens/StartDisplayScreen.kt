package com.samara.start_display.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.samara.start_display.presentation.navigation.IStartDisplayNavigation


@Composable
fun StartDisplayScreen(
    startDisplayNavigation: IStartDisplayNavigation,
    vm: StartDisplayVm,
    modifier: Modifier = Modifier
) {
    val state by vm.state.collectAsState()

    Text(
        text = state.title,
        modifier = modifier
    )
}