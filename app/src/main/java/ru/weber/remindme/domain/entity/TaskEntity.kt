package ru.weber.remindme.domain.entity

data class TaskEntity(
    val date: String,
    val description: String,
    val id: Long? = null,
)