package com.example.yandexproject.recyclerview

import android.content.Context
import com.example.yandexproject.recyclerview.TodoItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import java.util.*

class TasksPreviewRepository {
    private val _tasksList = mutableListOf<TodoItem>()
    val tasksList: List<TodoItem>
        get() = _tasksList

    private val _taskUpdatedFlow = MutableStateFlow(Unit)
    val taskUpdatedFlow: Flow<Unit>
        get() = _taskUpdatedFlow

    init {
        addTask(
            TodoItem(
                taskId = "1",
                taskText = "Task 1",
                importance = TodoItem.Importance.LOW,
                taskDone = true,
                deadline = Date(),
                createdAt = Date(),
                modifiedAt = Date()
            )
        )
        addTask(
            TodoItem(
                taskId = "2",
                taskText = "Task 2",
                importance = TodoItem.Importance.HIGH,
                taskDone = false,
                deadline = null,
                createdAt = Date(),
                modifiedAt = Date()
            )
        )
        addTask(
            TodoItem(
                taskId = "3",
                taskText = "Task 3 with long text\nLine 2\nLine 3klwb4FGBWAERHIGBEBRTGYIWABRGBWIURGBUIWEBRGBWIURGBUIBWRUIGBRNIWAPNRIGNPWEIRGNAEOUILAENRG",
                importance = TodoItem.Importance.COMMON,
                taskDone = false,
                deadline = Date(),
                createdAt = Date(),
                modifiedAt = null
            )
        )
    }

    fun getTasks(context: Context): List<TodoItem> {
        return tasksList
    }

    fun addTask(task: TodoItem) {
        _tasksList.add(task)
        _taskUpdatedFlow.value = Unit
    }
}