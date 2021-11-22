package ru.weber.remindme.data.task

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import ru.weber.remindme.data.database.TaskDao
import ru.weber.remindme.data.database.TaskDto
import ru.weber.remindme.domain.entity.TaskEntity
import ru.weber.remindme.domain.repository.TaskRepository
import javax.inject.Inject

class TaskRoomRepository @Inject constructor(private val taskDao: TaskDao) : TaskRepository {
    override fun getAllTask(): Flow<List<TaskEntity>> {
        return taskDao.getAllTask().map { listTaskDto ->
            listTaskDto.map { taskDto -> mapDtoToEntity(taskDto) }
        }
    }


    override fun getTask(id: Long): Flow<TaskEntity> {
        return taskDao.getTask(id).map { mapDtoToEntity(it) }
    }

    override suspend fun setTask(taskEntity: TaskEntity) {
        withContext(Dispatchers.IO) {
            taskDao.insert(mapEntityToDto(taskEntity))
        }
    }

    override suspend fun delete(id: Long) {
        withContext(Dispatchers.IO) {
            taskDao.getTask(id).collect { deletedTask ->
                taskDao.delete(deletedTask)
            }
        }

    }

    private fun mapDtoToEntity(taskDto: TaskDto): TaskEntity =
        TaskEntity(id = taskDto.id, date = taskDto.date, description = taskDto.description)

    private fun mapEntityToDto(entity: TaskEntity): TaskDto =
        TaskDto(entity.date, entity.description)
}