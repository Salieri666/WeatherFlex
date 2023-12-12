package com.samara.start_display.di

import androidx.lifecycle.ViewModel
import com.samara.core.di.vm.ViewModelAssistedFactory
import com.samara.start_display.presentation.screens.StartDisplayVm
import dagger.Binds
import dagger.Module

@Module
interface VmModule {

    @Binds
    @StartDisplayScope
    fun bindStartDisplayVmFactory(factory: StartDisplayVm.Factory): ViewModelAssistedFactory<out ViewModel>
}