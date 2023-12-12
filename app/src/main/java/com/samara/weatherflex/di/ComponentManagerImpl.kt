package com.samara.weatherflex.di

import com.samara.core.di.base.ComponentManager
import com.samara.core.di.components.CoreComponentHolder
import com.samara.core.presentation.navigation.Destination
import com.samara.start_display.di.StartDisplayComponentDependencies
import com.samara.start_display.di.StartDisplayComponentHolder
import com.samara.start_display.presentation.navigation.StartScreenDestination

class ComponentManagerImpl : ComponentManager {

    override fun attachComponentTo(destination: Destination) {
        when (destination) {
            StartScreenDestination -> StartDisplayComponentHolder.init(
                StartDisplayComponentDependencies(CoreComponentHolder.get())
            )
        }
    }

    override fun detachComponentFrom(destination: Destination) {
        when (destination) {
            StartScreenDestination -> StartDisplayComponentHolder.clear()
        }
    }
}