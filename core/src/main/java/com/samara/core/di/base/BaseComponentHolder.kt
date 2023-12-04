package com.samara.core.di.base

open class BaseComponentHolder<Component, Dependencies : ComponentDependencies> {
    private var _component: Component? = null
    fun get(): Component = _component ?: error("${this::class.java.simpleName}: component isn't initialized")

    private fun initializeComponent(initializer: () -> Component): Component {
        if (_component == null) {
            _component = initializer()
        }
        return get();
    }
    open fun init(): Component = initializeComponent { createComponent() }
    open fun init(dependencies: Dependencies): Component = initializeComponent { createComponent(dependencies) }


    open fun createComponent(): Component = get()
    open fun createComponent(dependencies: Dependencies): Component = get()

    open fun clear() {
        _component = null
    }
}