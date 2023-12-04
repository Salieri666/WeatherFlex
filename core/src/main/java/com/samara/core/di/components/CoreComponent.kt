package com.samara.core.di.components

import android.content.Context
import com.samara.core.data.pref.IPrefsStorage
import com.samara.core.data.resourceProvider.IResourceProvider
import com.samara.core.di.modules.CoreModule
import com.samara.core.di.modules.DefaultDispatcher
import com.samara.core.di.modules.DispatcherModule
import com.samara.core.di.modules.IoDispatcher
import com.samara.core.di.modules.MainDispatcher
import com.samara.core.di.modules.StorageModule
import com.samara.core.di.scope.CoreScope
import dagger.Component
import kotlinx.coroutines.CoroutineDispatcher


@Component(
    modules = [CoreModule::class, StorageModule::class, DispatcherModule::class],
    dependencies = [AppCoreComponent::class]
)
@CoreScope
interface CoreComponent {
    fun provideContext(): Context
    fun providePrefsStorage(): IPrefsStorage
    fun provideResourceProvider(): IResourceProvider

    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher

    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher

    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher
}