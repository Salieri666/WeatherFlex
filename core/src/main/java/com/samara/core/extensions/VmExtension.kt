package com.samara.core.extensions

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.samara.core.di.vm.ViewModelAssistedFactory
import com.samara.core.di.vm.ViewModelFactory

@Composable
inline fun <reified T : ViewModel> SavedStateRegistryOwner.getVm(
    factory: ViewModelAssistedFactory<T>
) = viewModel(
    modelClass = T::class.java,
    factory = ViewModelFactory(factory, this)
)