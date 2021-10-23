package ru.weber.remindme.ui.feature.setting

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.domain.interactor.SettingInteractor
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val settingInteractor: SettingInteractor
) : BaseViewModel() {

    val themeState: Flow<Boolean>
        get() = settingInteractor.getThemeSettingData()

    fun changeTheme(isDarkTheme: Boolean) {
        launch {
            settingInteractor.changeTheme(isDarkTheme)
        }
    }
}