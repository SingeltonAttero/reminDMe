package ru.weber.remindme.ui.feature.task.detailed

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.domain.entity.TaskEntity
import ru.weber.remindme.domain.interactor.TaskInteractor
import ru.weber.remindme.domain.interactor.date.DateInteractor
import ru.weber.remindme.ui.feature.task.detailed.state.TaskDetailedState
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class TaskDetailedViewModel @Inject constructor(
    private val dateInteractor: DateInteractor,
    private val taskInteractor: TaskInteractor
) :
    BaseViewModel() {

    private val mutableState: MutableStateFlow<TaskDetailedState> =
        MutableStateFlow(TaskDetailedState.Loading)

    private val mutableCommandOpenDialog = MutableSharedFlow<Boolean>()

    val state
        get() = mutableState
            .asStateFlow()

    val commandOpenDialog
        get() = mutableCommandOpenDialog.asSharedFlow()

    init {
        launch {
            delay(1000)
            setTextValues("")
        }
    }


    fun setTextValues(text: String) {
        launch {
            mutableState.emit(
                mutableState.value.reducerState(
                    TaskDetailedState.Result(
                        textValue = text,
                        dateField = dateInteractor.parseDate()
                    )
                )
            )
        }
    }

    fun setLocalDate(date: LocalDate) {
        launch {
            mutableState.emit(
                mutableState.value.reducerState(
                    TaskDetailedState.Result(dateField = dateInteractor.parseDate(date))
                )
            )
        }
    }

    fun commandDialog(isOpen: Boolean) {
        launch {
            mutableCommandOpenDialog.emit(isOpen)
        }
    }

    fun saveTask() {
        launch {
            when (val currentState = state.value) {
                is TaskDetailedState.Result -> taskInteractor.saveTask(
                    TaskEntity(
                        date = currentState.dateField,
                        description = currentState.textValue
                    )
                )
                is TaskDetailedState.Loading -> Unit
            }

        }
    }
}
