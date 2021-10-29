package ru.weber.remindme.ui.feature.task.detailed.state

import java.time.LocalDate

sealed class TaskDetailedState {

    object Loading : TaskDetailedState()

    data class Result(
        val editMode: Boolean = false,
        val textValue: String = "",
        val localDate: LocalDate = LocalDate.now()
    ) : TaskDetailedState()

    fun reducerState(
        newState: TaskDetailedState
    ): TaskDetailedState {
        if (this == newState) return newState
        return when (this) {
            Loading -> {
                when (newState) {
                    Loading -> this

                    is Result -> Result(
                        editMode = newState.editMode,
                        textValue = newState.textValue,
                        localDate = newState.localDate
                    )
                }
            }
            is Result -> {
                when (newState) {
                    Loading -> Loading
                    is Result -> {
                        this.copy(
                            editMode = newState.editMode,
                            textValue = newState.textValue,
                            localDate = newState.localDate
                        )
                    }
                }
            }
        }
    }
}

