package ru.weber.remindme.domain.repository

import kotlinx.coroutines.flow.Flow
import ru.weber.remindme.domain.entity.TaskEntity

interface TaskRepository {
    fun getAllTask(): Flow<List<TaskEntity>>
    fun getTask(id: Long): Flow<TaskEntity>
    suspend fun setTask(taskEntity: TaskEntity)
    suspend fun delete(id: Long)
}