package com.samara.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavController

interface Result
interface INavigation {

    val navController: NavController
    val callback: ((result: Result) -> Unit)?
    fun back()
    fun <T : Result> sendResult(result: T)

}

@Stable
open class BaseNavigation(
    override val navController: NavController
) : INavigation {

    override val callback: ((result: Result) -> Unit)? = null
    override fun back() {
        navController.popBackStack()
    }

    override fun <T : Result> sendResult(result: T) {
        callback?.invoke(result)
    }

}

@Composable
fun rememberBaseNavigation(navController: NavController): INavigation = remember(
    navController
) {
    BaseNavigation(navController)
}