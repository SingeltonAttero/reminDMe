package ru.weber.remindme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch

class RemindMeViewModel : ViewModel() {
    private val themeAction: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val themeState: Flow<Boolean>
        get() = themeAction

    fun changeTheme() {
        viewModelScope.launch {
            themeAction.emit(!themeAction.value)
        }
    }
}