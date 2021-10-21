package ru.weber.remindme.ui.feature.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.weber.remindme.R
import ru.weber.remindme.ui.feature.screens.BottomStartScreens

@Composable
fun SettingScreen(settingViewModel: SettingViewModel) {
    val stateTheme = settingViewModel.themeState.collectAsState(true)
    Scaffold(topBar = {
        TopAppBar(backgroundColor = MaterialTheme.colors.primaryVariant) {
            Text(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                text = stringResource(id = BottomStartScreens.Setting.titleToolbarRes),
                style = MaterialTheme.typography.h6
            )
        }
    }) {
        Card(
            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 6.dp)
                .clickable {
                    settingViewModel.changeTheme(!stateTheme.value)
                },
            backgroundColor = MaterialTheme.colors.primaryVariant,
            elevation = 8.dp
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Text(
                    modifier = Modifier
                        .weight(1F)
                        .padding(end = 16.dp),
                    text = stringResource(id = R.string.dark_theme_mode_title)
                )
                Switch(checked = stateTheme.value, onCheckedChange = {
                    settingViewModel.changeTheme(it)
                })
            }
        }
    }

}