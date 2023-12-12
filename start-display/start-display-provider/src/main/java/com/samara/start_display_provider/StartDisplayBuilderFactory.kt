package com.samara.start_display_provider

import com.samara.start_display_api.di.StartDisplayApiComponent
import com.samara.start_display_impl.di.DaggerStartDisplayApiComponentImpl

fun StartDisplayApiComponent.Companion.builder(): StartDisplayApiComponent.Builder =
    DaggerStartDisplayApiComponentImpl.builder()