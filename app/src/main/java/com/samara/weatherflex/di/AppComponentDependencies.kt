package com.samara.weatherflex.di

import com.samara.core.di.base.ComponentDependencies
import com.samara.core.di.components.CoreComponent

data class AppComponentDependencies(
    val coreComponent: CoreComponent
) : ComponentDependencies
