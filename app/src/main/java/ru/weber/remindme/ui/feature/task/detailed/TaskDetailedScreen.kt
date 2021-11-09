package ru.weber.remindme.ui.feature.task.detailed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ru.weber.remindme.R
import ru.weber.remindme.ui.component.toolbar.AppToolbar
import ru.weber.remindme.ui.component.toolbar.ToolbarTitle
import ru.weber.remindme.ui.feature.datepicker.DatePickerDialog
import ru.weber.remindme.ui.feature.task.detailed.state.TaskDetailedState

@Composable
fun TaskDetailedScreen(
    navHostController: NavHostController,
    titleTask: String,
    viewModel: TaskDetailedViewModel = hiltViewModel(),

    ) {
    val state = viewModel.state.collectAsState().value
    val dialogState = viewModel.commandOpenDialog.collectAsState(initial = false).value
    Scaffold(
        topBar = {
            AppToolbar(toolbarTitle = ToolbarTitle(title = titleTask, true)) {
                navHostController.popBackStack()
            }
        }
    ) { paddingValues ->
        if (state is TaskDetailedState.Result) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.textValue,
                    onValueChange = viewModel::setTextValues,
                    label = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                modifier = Modifier.padding(start = 16.dp),
                                text = stringResource(R.string.write_what_do_it_hint)
                            )
                        }
                    })

                if (dialogState) {
                    DatePickerDialog(onDateSelected = {
                        viewModel.setLocalDate(it)
                    }, onCloseDialog = {
                        viewModel.commandDialog(false)
                    })
                } else {
                    Text(modifier = Modifier.clickable {
                        viewModel.commandDialog(true)
                    }, text = state.dateField)
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .padding(paddingValues = paddingValues)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator()
            }
        }
    }
}