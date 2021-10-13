package ru.weber.remindme

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.weber.remindme.component.task.TaskTextItemView
import ru.weber.remindme.component.task.state.TaskStateMock
import ru.weber.remindme.ui.theme.RemindMeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RemindMeDark()
        }
    }
}

@Composable
private fun Activity.RemindMeDark(activityViewModel: RemindMeViewModel = viewModel()) {
    val stateTheme = activityViewModel.themeState.collectAsState(initial = isSystemInDarkTheme())
    RemindMeTheme(darkTheme = stateTheme.value) {
        window.statusBarColor = MaterialTheme.colors.primary.toArgb()
        window.navigationBarColor = MaterialTheme.colors.primary.toArgb()
        Surface(
            modifier = Modifier
                .clickable {
                    activityViewModel.changeTheme()
                }
                .fillMaxSize(),

            color = MaterialTheme.colors.background) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TaskStateMock.taskTextMock.forEach {
                    TaskTextItemView(state = it, Modifier)
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RemindMeTheme {
        Greeting("Android")
    }
}