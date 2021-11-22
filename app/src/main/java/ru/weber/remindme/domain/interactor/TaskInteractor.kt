package ru.weber.remindme.domain.interactor

import kotlinx.coroutines.flow.Flow
import ru.weber.remindme.domain.entity.TaskEntity
import ru.weber.remindme.domain.repository.TaskRepository

class TaskInteractor(private val repository: TaskRepository) {
    suspend fun saveTask(taskEntity: TaskEntity) {
        repository.setTask(taskEntity = taskEntity)
    }

    fun getAllTask(): Flow<List<TaskEntity>> = repository.getAllTask()
}