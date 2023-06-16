package com.example.yandexproject.recyclerview

import android.graphics.drawable.Drawable

data class TodoItem(
    val taskId: Int,
    val taskText: String,
//    val taskImportance: Int,
    val taskDone: Boolean,
//    val dateDeadline: Int?,
//    val dateCreation: Int,
//    val dateChanging: Int?
)
