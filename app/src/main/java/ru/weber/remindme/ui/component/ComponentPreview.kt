package ru.weber.remindme.ui.component.task

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.weber.remindme.ui.component.task.state.TaskStateMock
import ru.weber.remindme.ui.component.toolbar.AppToolbar
import ru.weber.remindme.ui.component.toolbar.ToolbarTitle
import ru.weber.remindme.ui.feature.screens.BottomStartScreens
import ru.weber.remindme.ui.theme.*


@Preview(showBackground = true)
@Composable
fun DefaultPreviewLight() {
    RemindMeTheme(false) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TaskStateMock.taskTextMock.forEach {
                TaskTextItemView(state = it, Modifier)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreviewDark() {
    RemindMeTheme(true) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            TaskStateMock.taskTextMock.forEach {
                TaskTextItemView(state = it, Modifier)
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun AppBarDarkPreview() {
    AppToolbar(
        toolbarTitle = ToolbarTitle(BottomStartScreens.Setting.titleToolbarRes),
        backgroundColor = PrimaryVariantDark,
        style = TypographyDark.h6
    )
}

@Composable
@Preview(showBackground = true)
private fun AppBarLightPreview() {
    AppToolbar(
        toolbarTitle = ToolbarTitle(BottomStartScreens.Setting.titleToolbarRes),
        backgroundColor = PrimaryVariantLight,
        style = TypographyLight.h6
    )
}