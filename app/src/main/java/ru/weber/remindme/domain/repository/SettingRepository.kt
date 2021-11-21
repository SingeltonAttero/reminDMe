package ru.weber.remindme.domain.repository

import kotlinx.coroutines.flow.Flow

interface SettingRepository {
    fun getThemeSetting(): Flow<Boolean>
    suspend fun changeTheme(isDarkTheme: Boolean)
}