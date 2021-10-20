package ru.weber.remindme.ui.component.task.state

sealed class TaskState {
    data class TextItem(
        val title: String,
        val status: TaskStatus
    )
}

enum class TaskStatus {
    COMPLETE,
    CANCELED,
    PROCESS
}