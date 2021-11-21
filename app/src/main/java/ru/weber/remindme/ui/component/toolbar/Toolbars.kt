package ru.weber.remindme.ui.component.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.weber.remindme.ui.theme.LightColor


@Composable
fun AppToolbar(
    toolbarTitle: ToolbarTitle,
    backgroundColor: Color = MaterialTheme.colors.primaryVariant,
    style: TextStyle = MaterialTheme.typography.h6,
    backPressedClick: () -> Unit = {}
) {
    TopAppBar(backgroundColor = backgroundColor) {
        if (toolbarTitle.backPressedIcon) {
            IconButton(onClick = {
                backPressedClick.invoke()
            }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = toolbarTitle.title(),
                    tint = LightColor.textAndIcon
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(if (toolbarTitle.backPressedIcon) 0.dp else 16.dp)
                .fillMaxWidth(),
            text = toolbarTitle.title(),
            style = style,
            color = LightColor.textAndIcon
        )
    }
}

@Composable
private fun ToolbarTitle.title(): String {
    return when (this) {
        is ToolbarTitle.DynamicTitle -> title
        is ToolbarTitle.StaticTitle -> stringResource(id = stringRes)
    }
}
