package com.samara.core.di.components

import com.samara.core.di.base.BaseComponentHolder

object CoreComponentHolder : BaseComponentHolder<CoreComponent, CoreComponentDependencies>() {

    override fun createComponent(dependencies: CoreComponentDependencies): CoreComponent {
        return DaggerCoreComponent.builder()
            .appCoreComponent(dependencies.appCoreComponent)
            .build()
    }
}