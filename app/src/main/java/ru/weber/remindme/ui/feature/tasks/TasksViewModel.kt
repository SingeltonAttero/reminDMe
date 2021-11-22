package ru.weber.remindme.ui.feature.tasks

import android.util.Log
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.domain.interactor.TaskInteractor
import ru.weber.remindme.ui.component.task.state.TaskState
import ru.weber.remindme.ui.component.task.state.TaskStatus
import ru.weber.remindme.ui.feature.tasks.converter.TaskScreenConverter
import ru.weber.remindme.ui.feature.tasks.state.TaskScreenState
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val taskInteractor: TaskInteractor,
    converter: TaskScreenConverter
) : BaseViewModel() {
    private val mutableState = MutableStateFlow(
        TaskScreenState.Result(
            converter.createStaticFabState(),
            listOf()
        )
    )
    val state
        get() = mutableState.asStateFlow()

    init {
        launch {
            taskInteractor
                .getAllTask()
                .catch { Log.e(this::class.java.name, it.message, it) }
                .collect { tasks ->
                    mutableState.emit(state.value.copy(
                        tasksItems = tasks.map {
                            TaskState.TextItem(it.description, TaskStatus.PROCESS)
                        }
                    ))
                }
        }
    }

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