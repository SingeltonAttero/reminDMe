package ru.weber.remindme.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.weber.remindme.domain.interactor.SettingInteractor
import ru.weber.remindme.domain.interactor.TaskInteractor
import ru.weber.remindme.domain.interactor.date.DateInteractor
import ru.weber.remindme.domain.repository.SettingRepository
import ru.weber.remindme.domain.repository.TaskRepository
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DomainProviderModuleDI {

    @Singleton
    @Provides
    fun providerSettingInteractor(settingRepository: SettingRepository): SettingInteractor =
        SettingInteractor(settingRepository = settingRepository)

    @Singleton
    @Provides
    fun providerDateInteractor(): DateInteractor = DateInteractor()

    @Provides
    @Singleton
    fun providesTaskInteractor(taskRepository: TaskRepository): TaskInteractor =
        TaskInteractor(taskRepository)
}

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindsModuleDi {

}