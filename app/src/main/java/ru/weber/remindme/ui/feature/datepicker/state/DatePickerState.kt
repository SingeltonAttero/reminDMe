package ru.weber.remindme.ui.feature.datepicker.state

import java.time.LocalDate

data class DatePickerState(
    val titleSelectDate: String,
    val currentDate: LocalDate
)

