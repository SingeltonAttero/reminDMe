package ru.weber.remindme.data.database

import android.content.Context
import androidx.room.Room
import javax.inject.Inject
import javax.inject.Provider

class AppDatabaseProvider @Inject constructor(private val context: Context) :
    Provider<AppDatabase> {
    override fun get(): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "app_database")
            .build()
}