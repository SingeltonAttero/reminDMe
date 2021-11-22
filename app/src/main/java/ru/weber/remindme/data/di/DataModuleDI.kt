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
import ru.weber.remindme.data.database.AppDatabase
import ru.weber.remindme.data.database.AppDatabaseProvider
import ru.weber.remindme.data.database.TaskDao
import ru.weber.remindme.data.datastore.AppSetting
import ru.weber.remindme.data.datastore.AppSettingDataStoreProvider
import ru.weber.remindme.data.datastore.AppSettingSerializer
import ru.weber.remindme.data.setting.ProtoDataStoreSettingRepository
import ru.weber.remindme.data.task.TaskRoomRepository
import ru.weber.remindme.domain.repository.SettingRepository
import ru.weber.remindme.domain.repository.TaskRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataProvideModule {

    private val Context.appSettingDataStore: DataStore<AppSetting> by dataStore(
        fileName = "setting.proto",
        serializer = AppSettingSerializer
    )

    @Provides
    @Singleton
    fun providesSettingDataStore(@ApplicationContext context: Context): AppSettingDataStoreProvider {
        return AppSettingDataStoreProvider(context.appSettingDataStore)
    }

    @Provides
    @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context): AppDatabase =
        AppDatabaseProvider(context = context).get()

    @Provides
    @Singleton
    fun providesTaskDao(appDatabase: AppDatabase): TaskDao = appDatabase.taskDao()

}

@Module
@InstallIn(SingletonComponent::class)
interface DataBindModule {

    @Binds
    @Singleton
    fun bindSettingRepository(protoDataStoreSettingRepository: ProtoDataStoreSettingRepository): SettingRepository

    @Binds
    @Singleton
    fun bindTaskRepository(taskRoomRepository: TaskRoomRepository): TaskRepository
}
