package com.example.yandexproject.recyclerview

import android.graphics.drawable.Drawable
import java.util.Date

data class TodoItem(
    val taskId: String,
    val taskText: String,
    val importance: Importance,
    val taskDone: Boolean,
    val deadline: Date?,
    val createdAt: Date,
    val modifiedAt: Date?,
) {
    enum class Importance {
        LOW,
        COMMON,
        HIGH,
    }
}