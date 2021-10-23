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
        contentColor = MaterialTheme.colors.surface,
        text = {
            Text(text = stringResource(id = state.name))
        },
        icon = {
            Icon(
                painter = painterResource(id = state.drawableRes),
                contentDescription = stringResource(id = state.name)
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
        contentColor = MaterialTheme.colors.surface,
        onClick = {
            clickFAB.invoke()
        },
    ) {
        Icon(
            painter = painterResource(id = state.drawableRes),
            contentDescription = state.drawableRes.toString()
        )
    }
}