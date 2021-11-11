package ru.weber.remindme.ui.feature.datepicker

import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import ru.weber.remindme.R
import java.time.LocalDate


@Composable
fun DatePickerDialog(
    onDateSelected: (LocalDate) -> Unit,
    onCloseDialog: () -> Unit,
    viewModel: DatePickerViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState().value

    Dialog(onDismissRequest = { onCloseDialog() }, properties = DialogProperties()) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(size = 16.dp)
                )
        ) {
            Column(
                Modifier
                    .defaultMinSize(minHeight = 72.dp)
                    .fillMaxWidth()
                    .background(
                        color = MaterialTheme.colors.primary,
                        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .padding(16.dp)
            ) {
                Text(
                    text = stringResource(R.string.select_date_remind).uppercase(),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.size(24.dp))

                Text(
                    text = state.titleSelectDate,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface
                )

                Spacer(modifier = Modifier.size(16.dp))
            }

            CustomCalendarView(onDateSelected = { year: Int, month: Int, dayOfMonth: Int ->
                viewModel.selectNewDate(year, month, dayOfMonth)
            })

            Spacer(modifier = Modifier.size(8.dp))

            Row(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 16.dp, end = 16.dp)
            ) {
                TextButton(
                    onClick = { onCloseDialog.invoke() }
                ) {
                    Text(
                        text = stringResource(R.string.cancel),
                        style = MaterialTheme.typography.button,
                    )
                }

                TextButton(
                    onClick = {
                        onDateSelected.invoke(state.currentDate)
                        onCloseDialog.invoke()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.select),
                        style = MaterialTheme.typography.button
                    )
                }

            }
        }
    }
}

@Composable
private fun CustomCalendarView(onDateSelected: (year: Int, month: Int, dayOfMonth: Int) -> Unit) {
    // Adds view to Compose
    AndroidView(
        modifier = Modifier.wrapContentSize(),
        factory = { context ->
            CalendarView(ContextThemeWrapper(context, R.style.CalenderViewCustom))
        },
        update = { view ->
            view.setOnDateChangeListener { _, year, month, dayOfMonth ->
                onDateSelected.invoke(year, month, dayOfMonth)
            }
        }
    )
}
