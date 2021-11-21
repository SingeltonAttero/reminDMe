package ru.weber.remindme.ui.component.toolbar

import androidx.annotation.StringRes

sealed class ToolbarTitle(open val backPressedIcon: Boolean) {

    data class StaticTitle(
        @StringRes val stringRes: Int,
        override val backPressedIcon: Boolean
    ) : ToolbarTitle(backPressedIcon)

    data class DynamicTitle(
        val title: String,
        override val backPressedIcon: Boolean
    ) : ToolbarTitle(backPressedIcon)

}

fun ToolbarTitle(
    @StringRes stringRes: Int,
    backPressedIcon: Boolean = false
): ToolbarTitle {
    return ToolbarTitle.StaticTitle(stringRes = stringRes, backPressedIcon = backPressedIcon)
}

fun ToolbarTitle(
    title: String,
    backPressedIcon: Boolean = false
): ToolbarTitle {
    return ToolbarTitle.DynamicTitle(title = title, backPressedIcon = backPressedIcon)
}