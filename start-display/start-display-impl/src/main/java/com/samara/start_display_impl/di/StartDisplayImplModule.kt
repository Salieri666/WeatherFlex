package com.samara.start_display_impl.di

import com.samara.start_display_api.domain.StartDisplayUseCase
import com.samara.start_display_impl.domain.StartDisplayUseCaseImpl
import dagger.Binds
import dagger.Module

@Module(includes = [StartDisplayImplModule.Bindings::class])
class StartDisplayImplModule {


    @Module
    interface Bindings {

        @Binds
        @StartDisplayImplScope
        fun getStartDisplayUseCase(useCaseImpl: StartDisplayUseCaseImpl): StartDisplayUseCase
    }
}