package com.samara.core.presentation.base

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch


abstract class BaseVM<S : State>(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    protected val tag: String = this::class.java.simpleName
    private val savedStateKey = tag

    //---State--------
    protected abstract val initialState: S
    val actualState: S
        get() = state.value

    @Suppress("LeakingThis")
    private val _state = MutableStateFlow(
        savedStateHandle[savedStateKey] ?: initialState
    )
    private val state = _state.asStateFlow()
    //---------------

    //---Action----
    private val actions = MutableSharedFlow<Action>()

    //---Effect----
    private val _effects = MutableSharedFlow<Any>()
    val effects = _effects.asSharedFlow()
    //-------------


    //---collect-actions-and-handle---
    init {
        viewModelScope.launch {
            actions.collect {
                _state.emitAll(
                    handleAction(it, actualState).catch { t ->
                        Log.d(tag, "Error in handle action", t)
                    }
                )
                savedStateHandle[savedStateKey] = _state.value
            }
        }
    }

    protected open fun handleAction(action: Action, actualState: S): Flow<S> = this.state

    fun sendAction(action: Action) {
        viewModelScope.launch {
            actions.emit(action)
        }
    }

    fun sendEffect(effect: Any) {
        viewModelScope.launch {
            _effects.emit(effect)
        }
    }

    protected fun <T> Flow<T>.toState(
        onLoading: (() -> S)? = null,
        onError: ((err: Throwable) -> S)? = null,
        onContent: suspend (data: T) -> S = { actualState }
    ): Flow<S> {
        return this.map { onContent(it) }
            .onStart { onLoading?.let { emit(it.invoke()) } }
            .catch { error ->
                Log.d(tag, "Error in toState method", error)
                onError?.let { emit(it.invoke(error)) }
            }
    }

    protected inline fun <T> flowOf(crossinline action: suspend () -> T): Flow<T> =
        flow { emit(action()) }

    protected inline fun Action.ignoreState(crossinline action: suspend () -> Unit = {}): Flow<S> = flow {
        action()
        emit(actualState)
    }
}