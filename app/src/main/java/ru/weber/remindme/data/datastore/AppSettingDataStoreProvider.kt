package ru.weber.remindme.data.datastore

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.map

class AppSettingDataStoreProvider(private val dataStore: DataStore<AppSetting>) {
    fun getDarkThemeState() = dataStore.data.map { it.darkTheme }
    suspend fun changeTheme(isDarkTheme: Boolean) = dataStore.updateData {
        it.toBuilder().setDarkTheme(isDarkTheme).build()
    }
}