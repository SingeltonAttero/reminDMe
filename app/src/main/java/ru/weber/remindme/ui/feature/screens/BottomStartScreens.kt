package ru.weber.remindme.ui.feature.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import ru.weber.remindme.R

sealed class BottomStartScreens(
    screenName: String,
    @StringRes titleToolbarRes: Int,
    @DrawableRes val bottomIconDrawable: Int
) : FlowScreens(screenName, titleToolbarRes) {

    object Home : BottomStartScreens(
        screenName = Home::class.java.name,
        titleToolbarRes = R.string.toolbar_home_title_start_screen,
        bottomIconDrawable = R.drawable.ic_bottom_home
    )

    object Setting : BottomStartScreens(
        screenName = Setting::class.java.name,
        titleToolbarRes = R.string.toolbar_setting_title_start_screen,
        bottomIconDrawable = R.drawable.ic_bottom_settings
    )

    object History : BottomStartScreens(
        screenName = History::class.java.name,
        titleToolbarRes = R.string.toolbar_history_title_start_screen,
        bottomIconDrawable = R.drawable.ic_bottom_briefcase
    )

    object Statistics : BottomStartScreens(
        Statistics::class.java.name,
        R.string.toolbar_statistic_title_start_screen,
        bottomIconDrawable = R.drawable.ic_bottom_statistic
    )
}