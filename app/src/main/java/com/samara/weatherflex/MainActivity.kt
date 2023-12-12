package com.samara.weatherflex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.samara.core.di.base.ComponentManager
import com.samara.core.di.base.LocalComponentsManager
import com.samara.core.extensions.getVm
import com.samara.ui_kit.theme.WeatherFlexTheme
import com.samara.weatherflex.di.AppComponentHolder
import com.samara.weatherflex.presentation.MainActivityScreen
import javax.inject.Inject

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @Inject
    lateinit var componentManager: ComponentManager;

    override fun onCreate(savedInstanceState: Bundle?) {
        AppComponentHolder.component?.inject(this)
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()
            CompositionLocalProvider(LocalComponentsManager provides componentManager) {
                WeatherFlexTheme {
                    Surface(
                        modifier = Modifier
                            .systemBarsPadding()
                            .fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {

                        MainActivityScreen(
                            navController = navController,
                            vm = LocalSavedStateRegistryOwner.current.getVm(
                                AppComponentHolder.get().mainActivityVmFactory()
                            )
                        )

                    }
                }
            }
        }
    }
}