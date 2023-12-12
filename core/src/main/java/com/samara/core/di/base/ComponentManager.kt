package com.samara.core.di.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.samara.core.presentation.navigation.Destination


val LocalComponentsManager: ProvidableCompositionLocal<ComponentManager> =
    compositionLocalOf { throw IllegalStateException("ComponentsManager isn't initialized") }
interface ComponentManager {

    fun attachComponentTo(destination: Destination)

    fun detachComponentFrom(destination: Destination)
}

@Composable
fun ComponentManagerLifecycle(
    destination: Destination,
    componentManager: ComponentManager = LocalComponentsManager.current
) {
    componentManager.attachComponentTo(destination)
    DisposableEffect(true) {
        onDispose {
            componentManager.detachComponentFrom(destination)
        }
    }
}