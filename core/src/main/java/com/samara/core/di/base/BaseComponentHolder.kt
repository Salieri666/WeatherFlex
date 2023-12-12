package com.samara.core.di.base

open class BaseComponentHolder<Component, Dependencies : ComponentDependencies> {
    var component: Component? = null
    fun get(): Component = component ?: error("${this::class.java.simpleName}: component isn't initialized")

    private fun initializeComponent(initializer: () -> Component): Component {
        if (component == null) {
            component = initializer()
        }
        return get();
    }
    fun init(): Component = initializeComponent { createComponent() }
    fun init(dependencies: Dependencies): Component = initializeComponent { createComponent(dependencies) }


    protected open fun createComponent(): Component = get()
    protected open fun createComponent(dependencies: Dependencies): Component = get()

    open fun clear() {
        component = null
    }
}