package ru.weber.remindme.data

import kotlinx.coroutines.flow.Flow
import ru.weber.remindme.data.datastore.AppSettingDataStoreProvider
import ru.weber.remindme.domain.repository.SettingRepository
import javax.inject.Inject

class ProtoDataStoreSettingRepository @Inject constructor(
    private val appSettingDataStore: AppSettingDataStoreProvider
) : SettingRepository {

    override fun getThemeSetting(): Flow<Boolean> {
        return appSettingDataStore.getDarkThemeState()
    }

    override suspend fun changeTheme(isDarkTheme: Boolean) {
        appSettingDataStore.changeTheme(isDarkTheme = isDarkTheme)
    }
}