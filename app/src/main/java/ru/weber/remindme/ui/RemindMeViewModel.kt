package ru.weber.remindme.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import ru.weber.remindme.domain.interactor.SettingInteractor
import javax.inject.Inject

@HiltViewModel
class RemindMeViewModel @Inject constructor(
    private val settingInteractor: SettingInteractor
) : ViewModel() {
    val themeState: Flow<Boolean>
        get() = settingInteractor.getThemeSettingData()

}