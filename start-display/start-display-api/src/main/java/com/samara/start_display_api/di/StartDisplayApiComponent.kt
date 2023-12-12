package com.samara.start_display_api.di

import com.samara.core.di.components.CoreComponent
import com.samara.start_display_api.domain.StartDisplayUseCase


interface StartDisplayApiComponent {

    interface Builder {
        fun coreComponent(component: CoreComponent): Builder

        fun build(): StartDisplayApiComponent
    }

    fun getStartDisplayUseCase(): StartDisplayUseCase

    companion object
}