package ru.weber.remindme.component.task.state

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