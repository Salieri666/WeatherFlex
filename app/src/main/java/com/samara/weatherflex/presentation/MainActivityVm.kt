package com.samara.weatherflex.presentation

import androidx.lifecycle.SavedStateHandle
import com.samara.core.di.vm.ViewModelAssistedFactory
import com.samara.core.presentation.base.BaseVM
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MainActivityVm @AssistedInject constructor(
    @Assisted savedStateHandle: SavedStateHandle
) : BaseVM<MainActivityState>(savedStateHandle) {

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<MainActivityVm>
    override val initialState: MainActivityState
        get() = MainActivityState()
}