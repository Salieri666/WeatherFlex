package com.samara.start_display.di

import com.samara.core.di.base.BaseComponentHolder
import com.samara.start_display_api.di.StartDisplayApiComponent
import com.samara.start_display_provider.builder

object StartDisplayComponentHolder :
    BaseComponentHolder<StartDisplayComponent, StartDisplayComponentDependencies>() {

    override fun createComponent(dependencies: StartDisplayComponentDependencies): StartDisplayComponent {
        return DaggerStartDisplayComponent.builder()
            .coreComponent(dependencies.coreComponent)
            .startDisplayApiComponent(
                StartDisplayApiComponent.builder()
                .coreComponent(dependencies.coreComponent)
                .build()
            )
            .build()
    }
}