package ru.weber.remindme.ui.feature.tasks

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.ui.component.task.state.TaskState
import ru.weber.remindme.ui.component.task.state.TaskStateMock
import ru.weber.remindme.ui.feature.tasks.converter.TaskScreenConverter
import ru.weber.remindme.ui.feature.tasks.state.TaskScreenState
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    converter: TaskScreenConverter
) : BaseViewModel() {
    private val mutableState = MutableStateFlow(
        TaskScreenState.Result(
            converter.createStaticFabState(),
            listOf(
                TaskStateMock.taskCheckboxMock,
                TaskStateMock.taskTextMock
            ).flatten()
        )
    )
    val state
        get() = mutableState.asStateFlow()

    fun doneTask(item: TaskState.CheckBoxItem, newChecked: Boolean) {
        val updateItems = mutableState.value.tasksItems.map {
            if (it == item && it is TaskState.CheckBoxItem) {
                it.copy(isChecked = newChecked)
            } else {
                it
            }
        }
        launch {
            mutableState.emit(mutableState.value.copy(tasksItems = updateItems))
        }
    }
}