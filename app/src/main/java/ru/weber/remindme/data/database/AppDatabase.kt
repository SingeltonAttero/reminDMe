package ru.weber.remindme.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}