package ru.weber.remindme.ui.feature.setting

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import ru.weber.remindme.R
import ru.weber.remindme.ui.component.switch.AppSwitch
import ru.weber.remindme.ui.component.toolbar.AppToolbar
import ru.weber.remindme.ui.component.toolbar.ToolbarTitle
import ru.weber.remindme.ui.feature.screens.BottomStartScreens

@Composable
fun SettingScreen(settingViewModel: SettingViewModel = hiltViewModel()) {
    val stateTheme = settingViewModel.themeState.collectAsState(true)
    Scaffold(topBar = {
        AppToolbar(ToolbarTitle(BottomStartScreens.Setting.titleToolbarRes))
    }) {
        AppSwitch(
            checked = stateTheme.value,
            titleRes = R.string.dark_theme_mode_title
        ) {
            settingViewModel.changeTheme(it)
        }
    }
}

