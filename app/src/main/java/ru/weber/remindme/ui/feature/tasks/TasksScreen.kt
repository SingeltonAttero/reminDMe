package ru.weber.remindme.ui.feature.tasks

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.weber.remindme.ui.component.fab.AppFab
import ru.weber.remindme.ui.component.task.TaskCheckboxItemView
import ru.weber.remindme.ui.component.task.TaskTextItemView
import ru.weber.remindme.ui.component.task.state.TaskState
import ru.weber.remindme.ui.component.toolbar.AppToolbar
import ru.weber.remindme.ui.component.toolbar.ToolbarTitle
import ru.weber.remindme.ui.screens.BottomStartScreens
import ru.weber.remindme.ui.screens.FlowScreens

@Composable
fun TasksScreen(
    navController: NavHostController,
    viewModel: TasksViewModel = hiltViewModel()
) {
    val screenState = viewModel.state.collectAsState()
    Scaffold(
        topBar = {
            AppToolbar(toolbarTitle = ToolbarTitle(BottomStartScreens.Tasks.titleToolbarRes))
        },
        floatingActionButton = {
            AppFab(state = screenState.value.fabState) {
                navController.navigate(FlowScreens.Task.screenKey)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { paddingValue ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValue)
                .padding(vertical = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            screenState.value.tasksItems.forEach { taskState ->
                item {
                    when (taskState) {
                        is TaskState.CheckBoxItem -> TaskCheckboxItemView(
                            state = taskState,
                            modifier = Modifier,
                            checked = {
                                viewModel.doneTask(taskState, it)
                            }
                        )
                        is TaskState.TextItem -> TaskTextItemView(
                            state = taskState,
                            modifier = Modifier
                        )
                    }
                }
            }
        }
    }
}
