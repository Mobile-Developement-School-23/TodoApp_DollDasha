package com.example.yandexproject.recyclerview

import android.content.Context

class TasksPreviewRepository {

    var tasksList = listOf<TodoItem>()

    fun getTasks(context: Context) : List<TodoItem> {
//        return buildList {
        addTask(TodoItem(0, "The United Kingdom is an advanced European island country. It is surrounded by three bodies of water: the North Sea, in the eastern part, the English", false))
        for (i in 1..20)
            addTask(TodoItem(i, "kotik", false))

        return tasksList
//            add(TodoItem(, "kotik", false))
//        }
    }

    fun addTask(task: TodoItem){
        tasksList = tasksList.plus(task)
    }
}