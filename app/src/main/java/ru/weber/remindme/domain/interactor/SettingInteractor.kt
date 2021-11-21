package ru.weber.remindme.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.weber.remindme.domain.repository.SettingRepository

class SettingInteractor(private val settingRepository: SettingRepository) {
    fun getThemeSettingData(): Flow<Boolean> = settingRepository.getThemeSetting()

    suspend fun changeTheme(isDarkTheme: Boolean) {
        settingRepository.changeTheme(isDarkTheme = isDarkTheme)
    }
}