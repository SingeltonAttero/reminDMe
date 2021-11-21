package ru.weber.remindme.ui.component.task.state

object TaskStateMock {
    val taskTextMock: List<TaskState.TextItem> = listOf(
        TaskState.TextItem("Сделать зарядку", status = TaskStatus.COMPLETE),
        TaskState.TextItem("Купить молоко", status = TaskStatus.PROCESS),
        TaskState.TextItem("Полить цветы", status = TaskStatus.CANCELED),
        TaskState.TextItem("Сделать зарядку хех", status = TaskStatus.COMPLETE),
        TaskState.TextItem("Купить молоко 12", status = TaskStatus.PROCESS),
        TaskState.TextItem("Полить цветы 4", status = TaskStatus.CANCELED),
    )

    val taskCheckboxMock: List<TaskState.CheckBoxItem> = mutableListOf(
        TaskState.CheckBoxItem(true, "Сделать зарядку?", status = TaskStatus.COMPLETE),
        TaskState.CheckBoxItem(false, "Купить молоко?", status = TaskStatus.PROCESS),
        TaskState.CheckBoxItem(false, "Полить цветы2?", status = TaskStatus.CANCELED),
        TaskState.CheckBoxItem(true, "Сделать зарядку вечером?", status = TaskStatus.COMPLETE),
        TaskState.CheckBoxItem(false, "Купить молоко?1", status = TaskStatus.PROCESS),
        TaskState.CheckBoxItem(false, "Полить цветы? у32", status = TaskStatus.CANCELED),
        TaskState.CheckBoxItem(true, "Сделать зарядку утром?", status = TaskStatus.COMPLETE),
        TaskState.CheckBoxItem(false, "Купить молоко?фы", status = TaskStatus.PROCESS),
        TaskState.CheckBoxItem(false, "Полить цветы?п", status = TaskStatus.CANCELED),
    ).apply {
        for (i in 0..100) {
            add(TaskState.CheckBoxItem(false, "Полить цветы? $i", status = TaskStatus.CANCELED))
        }
    }

}