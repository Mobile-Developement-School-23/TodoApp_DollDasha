package com.example.yandexproject.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.yandexproject.R

class TaskAdapter : RecyclerView.Adapter<taskPreviewViewHolder>() {
    var tasks = listOf<TodoItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): taskPreviewViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return taskPreviewViewHolder(
            layoutInflater.inflate(R.layout.task_preview, parent, false)
        )
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: taskPreviewViewHolder, position: Int) {
        holder.onBind(tasks[position])
    }

}