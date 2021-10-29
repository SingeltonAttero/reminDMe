package ru.weber.remindme.ui.feature.task.detailed

import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.ui.feature.task.detailed.state.TaskDetailedState
import java.time.LocalDate
import javax.inject.Inject

@ViewModelScoped
class TaskDetailedViewModel @Inject constructor() : BaseViewModel() {

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
                    TaskDetailedState.Result(textValue = text)
                )
            )
        }
    }

    fun setLocalDate(date: LocalDate) {
        launch {
            mutableState.emit(
                mutableState.value.reducerState(
                    TaskDetailedState.Result(localDate = date)
                )
            )
        }
    }

    fun commandDialog(isOpen: Boolean) {
        launch {
            mutableCommandOpenDialog.emit(isOpen)
        }
    }
}
