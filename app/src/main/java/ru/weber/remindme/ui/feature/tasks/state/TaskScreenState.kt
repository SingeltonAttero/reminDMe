package ru.weber.remindme.ui.feature.tasks.state

import ru.weber.remindme.ui.component.fab.FabState
import ru.weber.remindme.ui.component.task.state.TaskState

sealed class TaskScreenState {

    object Loading : TaskScreenState()

    data class Result(
        val fabState: FabState,
        val tasksItems: List<TaskState>
    )

}