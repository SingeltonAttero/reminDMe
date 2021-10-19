package ru.weber.remindme.component.task.state

object TaskStateMock {
    val taskTextMock = listOf(
        TaskState.TextItem("Сделать зарядку", status = TaskStatus.COMPLETE),
        TaskState.TextItem("Купить молоко", status = TaskStatus.PROCESS),
        TaskState.TextItem("Полить цветы", status = TaskStatus.CANCELED),
    )

}