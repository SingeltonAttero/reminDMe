package ru.weber.remindme.ui.feature.screens

import androidx.annotation.StringRes
import ru.weber.remindme.R

sealed class FlowScreens(
    val screenKey: String,
    @StringRes val titleToolbarRes: Int
) {
    object StartScreen : FlowScreens(StartScreen::class.java.simpleName, R.string.app_name)
}