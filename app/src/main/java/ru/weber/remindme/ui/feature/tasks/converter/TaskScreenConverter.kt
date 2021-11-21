package ru.weber.remindme.ui.feature.tasks.converter

import ru.weber.remindme.R
import ru.weber.remindme.ui.component.fab.FabState
import javax.inject.Inject

class TaskScreenConverter @Inject constructor() {

    fun createStaticFabState(isExtended: Boolean = true): FabState {
        return if (isExtended) {
            FabState.Extended(
                name = R.string.new_task,
                drawableRes = R.drawable.ic_component_tasks_add
            )
        } else {
            FabState.Circle(drawableRes = R.drawable.ic_component_add)
        }
    }

}