package ru.weber.remindme.ui.component.fab

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class FabState {
    data class Extended(
        @StringRes val name: Int,
        @DrawableRes val drawableRes: Int
    ) : FabState()

    data class Circle(@DrawableRes val drawableRes: Int) : FabState()
}
