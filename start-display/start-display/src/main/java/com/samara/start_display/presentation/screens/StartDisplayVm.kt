package com.samara.start_display.presentation.screens

import androidx.lifecycle.SavedStateHandle
import com.samara.core.di.vm.ViewModelAssistedFactory
import com.samara.core.presentation.base.Action
import com.samara.core.presentation.base.BaseVM
import com.samara.core.presentation.base.change
import com.samara.start_display_api.domain.StartDisplayUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow

class StartDisplayVm @AssistedInject constructor(
    private val startDisplayUseCase: StartDisplayUseCase,
    @Assisted savedStateHandle: SavedStateHandle
) : BaseVM<StartDisplayState>(savedStateHandle) {

    @AssistedFactory
    interface Factory : ViewModelAssistedFactory<StartDisplayVm>

    override val initialState: StartDisplayState
        get() = StartDisplayState()


    init {
        sendAction(StartDisplayAction.LoadNewTitle)
    }

    override fun handleAction(
        action: Action,
        actualState: StartDisplayState
    ): Flow<StartDisplayState> {
        return when (action) {
            is StartDisplayAction.LoadNewTitle -> handleStartAction(action, actualState)
            else -> super.handleAction(action, actualState)
        }
    }

    private fun handleStartAction(action: StartDisplayAction.LoadNewTitle, actualState: StartDisplayState): Flow<StartDisplayState> {
        return actualState.change {
            it.copy(title = startDisplayUseCase.getHelloWorld())
        }
    }
}