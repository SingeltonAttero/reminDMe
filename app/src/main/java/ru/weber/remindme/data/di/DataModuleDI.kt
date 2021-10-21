package ru.weber.remindme.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ru.weber.remindme.data.ProtoDataStoreSettingRepository
import ru.weber.remindme.data.datastore.AppSetting
import ru.weber.remindme.data.datastore.AppSettingDataStoreProvider
import ru.weber.remindme.data.datastore.AppSettingSerializer
import ru.weber.remindme.domain.repository.SettingRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataProvideModule {

    @Provides
    @Singleton
    fun providesSettingDataStore(@ApplicationContext context: Context): AppSettingDataStoreProvider {
        return AppSettingDataStoreProvider(context.appSettingDataStore)
    }

    private val Context.appSettingDataStore: DataStore<AppSetting> by dataStore(
        fileName = "setting.proto",
        serializer = AppSettingSerializer
    )
}

@Module
@InstallIn(SingletonComponent::class)
interface DataBindModule {

    @Binds
    @Singleton
    fun bindSettingRepository(protoDataStoreSettingRepository: ProtoDataStoreSettingRepository): SettingRepository
}
