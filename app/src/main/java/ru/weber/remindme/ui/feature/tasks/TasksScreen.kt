package ru.weber.remindme.ui.feature.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.weber.remindme.ui.component.fab.AppFab
import ru.weber.remindme.ui.component.task.TaskCheckboxItemView
import ru.weber.remindme.ui.component.task.TaskTextItemView
import ru.weber.remindme.ui.component.task.state.TaskStateMock
import ru.weber.remindme.ui.component.task.state.TaskStateMock.taskCheckboxMock
import ru.weber.remindme.ui.component.toolbar.AppToolbar
import ru.weber.remindme.ui.component.toolbar.ToolbarTitle
import ru.weber.remindme.ui.feature.screens.BottomStartScreens

@Composable
fun TasksScreen(viewModel: TasksViewModel = hiltViewModel()) {
    val fabState = viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            AppToolbar(toolbarTitle = ToolbarTitle(BottomStartScreens.Tasks.titleToolbarRes))
        },
        floatingActionButton = {
            AppFab(state = fabState.value) {

            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValue ->
        Column(
            modifier = Modifier
                .padding(paddingValue)
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TaskStateMock.taskTextMock.forEach {
                TaskTextItemView(state = it, Modifier)
            }

            taskCheckboxMock.forEach {
                TaskCheckboxItemView(state = it, Modifier)
            }
        }
    }
}
