package com.samara.core.di.components

import android.app.Application
import android.content.Context
import com.samara.core.di.modules.AppModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [AppModule::class]
)
@Singleton
interface AppCoreComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppCoreComponent
    }

    fun provideContext(): Context
}