package com.samara.weatherflex.di

import com.samara.core.di.base.ComponentManager
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    @AppScope
    fun provideComponentsManager(): ComponentManager = ComponentManagerImpl()
}