package ru.weber.remindme.ui.screens

import androidx.annotation.StringRes
import ru.weber.remindme.R

sealed class FlowScreens(
    val screenKey: String,
    @StringRes val titleToolbarRes: Int
) {
    object Start : FlowScreens(Start::class.java.simpleName, R.string.app_name)

    object Task : FlowScreens(Task::class.java.simpleName, R.string.app_name)
}