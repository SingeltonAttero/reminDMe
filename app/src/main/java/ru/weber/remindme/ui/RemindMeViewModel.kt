package ru.weber.remindme.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ru.weber.remindme.domain.interactor.SettingInteractor
import javax.inject.Inject

@HiltViewModel
class RemindMeViewModel @Inject constructor(
    private val settingInteractor: SettingInteractor
) : ViewModel() {
    private val themeAction: MutableStateFlow<Boolean> = MutableStateFlow(false)

    val themeState: Flow<Boolean>
        get() = themeAction

    init {
        viewModelScope.launch {
            settingInteractor.getThemeSettingData().collect {
                themeAction.emit(it)
            }
        }
    }
}