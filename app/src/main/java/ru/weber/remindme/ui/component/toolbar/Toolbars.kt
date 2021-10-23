package ru.weber.remindme.ui.component.toolbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.weber.remindme.ui.feature.screens.BottomStartScreens
import ru.weber.remindme.ui.theme.PrimaryVariantDark
import ru.weber.remindme.ui.theme.PrimaryVariantLight
import ru.weber.remindme.ui.theme.TypographyDark
import ru.weber.remindme.ui.theme.TypographyLight


@Composable
fun AppToolbar(
    toolbarTitle: ToolbarTitle,
    backgroundColor: Color = MaterialTheme.colors.primaryVariant,
    style: TextStyle = MaterialTheme.typography.h6
) {
    TopAppBar(backgroundColor = backgroundColor) {
        Text(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            text = toolbarTitle.title(),
            style = style
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
