package ru.weber.remindme.ui.feature.tasks

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.ui.feature.tasks.converter.TaskScreenConverter
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    converter: TaskScreenConverter
) : BaseViewModel() {
    private val mutableState = MutableStateFlow(converter.createStaticFabState())
    val state
        get() = mutableState.asStateFlow()
}