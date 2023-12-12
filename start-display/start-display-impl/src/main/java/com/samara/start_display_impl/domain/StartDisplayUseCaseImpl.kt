package com.samara.start_display_impl.domain

import android.content.Context
import com.samara.core.di.modules.IoDispatcher
import com.samara.start_display_api.domain.StartDisplayUseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class StartDisplayUseCaseImpl @Inject constructor(
    private val context: Context,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : StartDisplayUseCase {
    override fun getHelloWorld(): String {
        return "Hello world"
    }
}