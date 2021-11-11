package ru.weber.remindme.ui.component.fab

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource


@Composable
fun AppFab(
    state: FabState,
    clickFAB: () -> Unit
) {
    when (state) {
        is FabState.Circle -> AppCircleFAB(state = state, clickFAB = clickFAB)
        is FabState.Extended -> AppExtendedFAB(state = state, clickFAB = clickFAB)
    }
}


@Composable
fun AppExtendedFAB(
    state: FabState.Extended,
    clickFAB: () -> Unit
) {
    ExtendedFloatingActionButton(
        contentColor = MaterialTheme.colors.primary,
        backgroundColor = MaterialTheme.colors.secondary,
        text = {
            Text(text = stringResource(id = state.name), style = MaterialTheme.typography.body1)
        },
        icon = {
            Icon(
                painter = painterResource(id = state.drawableRes),
                contentDescription = stringResource(id = state.name),
                tint = MaterialTheme.colors.primary
            )
        },
        onClick = {
            clickFAB.invoke()
        },
    )
}

@Composable
fun AppCircleFAB(
    state: FabState.Circle,
    clickFAB: () -> Unit
) {
    FloatingActionButton(
        contentColor = MaterialTheme.colors.primary,
        backgroundColor = MaterialTheme.colors.secondary,
        onClick = {
            clickFAB.invoke()
        },
    ) {
        Icon(
            painter = painterResource(id = state.drawableRes),
            contentDescription = state.drawableRes.toString(),
            tint = MaterialTheme.colors.primary
        )
    }
}