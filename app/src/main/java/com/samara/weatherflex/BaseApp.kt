package com.samara.weatherflex

import android.app.Application
import com.samara.core.di.components.AppCoreComponent

import com.samara.core.di.components.CoreComponent
import com.samara.core.di.components.CoreComponentDependencies
import com.samara.core.di.components.CoreComponentHolder
import com.samara.core.di.components.DaggerAppCoreComponent
import com.samara.weatherflex.di.AppComponentDependencies
import com.samara.weatherflex.di.AppComponentHolder

open class BaseApp : Application() {
    private var appComponent: AppCoreComponent? = null
    private var coreComponent: CoreComponent? = null

    protected fun appComponent(): AppCoreComponent = appComponent ?: run {
        DaggerAppCoreComponent.builder().application(this).build()
    }

    protected fun coreComponent(): CoreComponent = coreComponent ?: run {
        CoreComponentHolder.init(
            CoreComponentDependencies(appComponent())
        )
    }

    override fun onCreate() {
        super.onCreate()
        AppComponentHolder.init(
            AppComponentDependencies(coreComponent())
        )
    }
}