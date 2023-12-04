package com.samara.core.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import com.samara.core.data.pref.IPrefsStorage
import com.samara.core.data.pref.PrefsStorage
import com.samara.core.data.resourceProvider.IResourceProvider
import com.samara.core.data.resourceProvider.ResourceProvider
import com.samara.core.di.scope.CoreScope


@Module(includes = [StorageModule.Bindings::class])
class StorageModule {

    @CoreScope
    @Provides
    fun providePrefsStorage(context: Context): IPrefsStorage = PrefsStorage(context)

    @Module
    interface Bindings {

        @CoreScope
        @Binds
        fun bind(resourceProvider: ResourceProvider): IResourceProvider
    }
}