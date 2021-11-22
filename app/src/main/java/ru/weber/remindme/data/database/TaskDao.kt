package ru.weber.remindme.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAllTask(): Flow<List<TaskDto>>

    @Query("SELECT * FROM task WHERE id in (:id)")
    fun getTask(id: Long): Flow<TaskDto>

    @Insert(onConflict = REPLACE)
    fun insert(vararg taskDto: TaskDto)

    @Delete
    fun delete(taskDto: TaskDto)
}