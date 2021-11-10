package ru.weber.remindme.ui.component.date

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import ru.weber.remindme.R

@Composable
fun TextFieldDate(
    dateField: String,
    modifier: Modifier = Modifier,
    title: String = "Когда?",
    iconDrawable: Painter = painterResource(id = R.drawable.ic_component_calendar_select_date),

    ) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = title)
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .border(
                    1.dp,
                    SolidColor(MaterialTheme.colors.onSurface),
                    RoundedCornerShape(8.dp)
                )
                .fillMaxWidth(1F)
                .then(modifier)
                .padding(8.dp)
        ) {
            Text(
                text = dateField, modifier = Modifier.padding(end = 16.dp)
            )
            Icon(
                painter = iconDrawable,
                contentDescription = dateField,
                tint = MaterialTheme.colors.onSurface
            )
        }
    }
}