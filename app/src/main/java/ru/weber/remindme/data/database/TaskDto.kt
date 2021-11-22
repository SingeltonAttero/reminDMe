package ru.weber.remindme.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskDto(
    @ColumnInfo val date: String,
    @ColumnInfo val description: String,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
)