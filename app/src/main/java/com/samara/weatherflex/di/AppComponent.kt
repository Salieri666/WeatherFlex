package com.samara.weatherflex.di

import com.samara.core.di.base.ComponentManager
import com.samara.core.di.components.CoreComponent
import com.samara.weatherflex.MainActivity
import com.samara.weatherflex.presentation.MainActivityVm
import dagger.Component

@Component(
    modules = [AppModule::class, VmModule::class],
    dependencies = [CoreComponent::class]
)
@AppScope
interface AppComponent {

    fun getComponentManager(): ComponentManager
    fun mainActivityVmFactory(): MainActivityVm.Factory
    fun inject(mainActivity: MainActivity)
}