package com.samara.start_display.di

import com.samara.core.di.components.CoreComponent
import com.samara.start_display.presentation.screens.StartDisplayVm
import com.samara.start_display_api.di.StartDisplayApiComponent
import dagger.Component

@Component(
    modules = [VmModule::class],
    dependencies = [CoreComponent::class, StartDisplayApiComponent::class]
)
@StartDisplayScope
interface StartDisplayComponent {

    fun getVmFactory(): StartDisplayVm.Factory
}