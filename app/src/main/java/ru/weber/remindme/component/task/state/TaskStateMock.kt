package ru.weber.remindme.component.task.state

object TaskStateMock {
    val taskTextMock = listOf(
        TaskState.TextItem("Полить цветы", status = TaskStatus.COMPLETE),
        TaskState.TextItem("Полить цветы", status = TaskStatus.PROCESS),
        TaskState.TextItem("Полить цветы", status = TaskStatus.CANCELED),
    )

}