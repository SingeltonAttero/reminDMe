package ru.weber.remindme.ui.component.switch

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp


@Composable
fun AppSwitch(
    checked: Boolean,
    titleRes: Int,
    onCheckedChange: (Boolean) -> Unit
) {
    AppSwitch(
        checked = checked,
        title = stringResource(id = titleRes),
        onCheckedChange = onCheckedChange
    )
}

@Composable
fun AppSwitch(
    checked: Boolean,
    title: String,
    onCheckedChange: (Boolean) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(vertical = 16.dp, horizontal = 6.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 8.dp
    ) {
        Row(modifier = Modifier
            .clickable {
                onCheckedChange.invoke(!checked)
            }
            .padding(16.dp)) {
            Text(
                modifier = Modifier
                    .weight(1F)
                    .padding(end = 16.dp),
                text = title
            )
            Switch(checked = checked, onCheckedChange = {
                onCheckedChange.invoke(it)
            })
        }
    }
}