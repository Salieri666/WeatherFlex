package com.samara.start_display_impl.di

import com.samara.core.di.components.CoreComponent
import com.samara.start_display_api.di.StartDisplayApiComponent
import dagger.Component

@Component(
    modules = [StartDisplayImplModule::class],
    dependencies = [CoreComponent::class]
)
@StartDisplayImplScope
interface StartDisplayApiComponentImpl : StartDisplayApiComponent {
    @Component.Builder
    interface Builder : StartDisplayApiComponent.Builder
}