package ru.weber.remindme.commons

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun launch(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            block.invoke(viewModelScope)
        }
    }

    fun <T> MutableStateFlow<T>.newState(reducer: () -> T) {
        return launch { this@newState.emit(reducer.invoke()) }
    }
}