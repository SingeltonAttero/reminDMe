package ru.weber.remindme.ui.feature.task.detailed.state

sealed class TaskDetailedState {

    object Loading : TaskDetailedState()

    data class Result(
        val editMode: Boolean = false,
        val textValue: String = "",
        val dateField: String = ""
    ) : TaskDetailedState() {
        val isVisibleDone: Boolean = textValue.isNotBlank() && dateField.isNotBlank()
    }


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
                        dateField = newState.dateField
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
                            dateField = newState.dateField
                        )
                    }
                }
            }
        }
    }
}

