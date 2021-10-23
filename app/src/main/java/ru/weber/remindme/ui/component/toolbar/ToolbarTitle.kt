package ru.weber.remindme.ui.component.toolbar

import androidx.annotation.StringRes

sealed class ToolbarTitle {
    data class StaticTitle(@StringRes val stringRes: Int) : ToolbarTitle()

    data class DynamicTitle(val title: String) : ToolbarTitle()

}

fun ToolbarTitle(@StringRes stringRes: Int): ToolbarTitle {
    return ToolbarTitle.StaticTitle(stringRes = stringRes)
}

fun ToolbarTitle(title: String): ToolbarTitle {
    return ToolbarTitle.DynamicTitle(title = title)
}