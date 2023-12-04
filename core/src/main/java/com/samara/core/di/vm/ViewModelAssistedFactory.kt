package com.samara.core.di.vm

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

interface ViewModelDiFactory
interface ViewModelAssistedFactory<T : ViewModel> : ViewModelDiFactory {
    fun create(handle: SavedStateHandle): T
}