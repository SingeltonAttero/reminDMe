package ru.weber.remindme.ui.component.task.state

object TaskStateMock {
    val taskTextMock = listOf(
        TaskState.TextItem("Сделать зарядку", status = TaskStatus.COMPLETE),
        TaskState.TextItem("Купить молоко", status = TaskStatus.PROCESS),
        TaskState.TextItem("Полить цветы", status = TaskStatus.CANCELED),
    )

    val taskCheckboxMock = listOf(
        TaskState.CheckBoxItem(true, "Сделать зарядку?", status = TaskStatus.COMPLETE),
        TaskState.CheckBoxItem(false, "Купить молоко?", status = TaskStatus.PROCESS),
        TaskState.CheckBoxItem(false, "Полить цветы?", status = TaskStatus.CANCELED),
    )

}