package com.samara.weatherflex.di

import androidx.lifecycle.ViewModel
import com.samara.core.di.vm.ViewModelAssistedFactory
import com.samara.weatherflex.presentation.MainActivityVm
import dagger.Binds
import dagger.Module

@Module
interface VmModule {

    @Binds
    @AppScope
    fun bindMainActivityVm(viewModelFactory: MainActivityVm.Factory): ViewModelAssistedFactory<out ViewModel>

}