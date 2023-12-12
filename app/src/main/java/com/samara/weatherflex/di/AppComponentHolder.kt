package com.samara.weatherflex.di

import com.samara.core.di.base.BaseComponentHolder

object AppComponentHolder : BaseComponentHolder<AppComponent, AppComponentDependencies>() {

    override fun createComponent(dependencies: AppComponentDependencies): AppComponent {
        return DaggerAppComponent.builder().coreComponent(dependencies.coreComponent).build()
    }

}