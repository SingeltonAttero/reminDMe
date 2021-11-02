package ru.weber.remindme.ui.feature.datepicker

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.weber.remindme.commons.BaseViewModel
import ru.weber.remindme.domain.interactor.date.DateInteractor
import ru.weber.remindme.ui.feature.datepicker.state.DatePickerState
import javax.inject.Inject

@HiltViewModel
class DatePickerViewModel @Inject constructor(private val dateInteractor: DateInteractor) :
    BaseViewModel() {

    private val mutableState = MutableStateFlow(
        DatePickerState(
            dateInteractor.parseDate(),
            dateInteractor.currentDate
        )
    )
    val state
        get() = mutableState.asStateFlow()


    fun selectNewDate(year: Int, month: Int, dayOfMonth: Int) {
        mutableState.newState {
            val newDate = dateInteractor.createLocalDate(year, month, dayOfMonth)
            mutableState.value.copy(
                currentDate = newDate,
                titleSelectDate = dateInteractor.parseDate(newDate)
            )
        }
    }

}