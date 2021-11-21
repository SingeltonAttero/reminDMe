package ru.weber.remindme.ui.component.task.state

sealed class TaskState(open val status: TaskStatus) {
    data class TextItem(
        val title: String,
        override val status: TaskStatus
    ) : TaskState(status)

    data class CheckBoxItem(
        val isChecked: Boolean,
        val title: String,
        override val status: TaskStatus
    ) : TaskState(status)
}

enum class TaskStatus {
    COMPLETE,
    CANCELED,
    PROCESS
}