package ru.weber.remindme.domain.interactor.date

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class DateInteractor @Inject constructor() {

    val currentDate: LocalDate
        get() = LocalDate.now()

    fun parseDate(
        date: LocalDate = currentDate,
        parsePattern: ParseDatePatten = ParseDatePatten.DD_MM_YYYY
    ): String {
        return date.format(DateTimeFormatter.ofPattern(parsePattern.patten))
    }

    fun createLocalDate(year: Int, month: Int, dayOfMonth: Int): LocalDate {
        return LocalDate.of(year, month + 1, dayOfMonth)
    }

}