package com.example.yandexproject.recyclerview

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yandexproject.R

class taskPreviewViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val doneCheckbox: CheckBox = itemView.findViewById(R.id.item_checkbox)
    private val previewTaskText: TextView = itemView.findViewById(R.id.preview_task_text)

    fun onBind(taskPreview: TodoItem) {
        doneCheckbox.isChecked = taskPreview.taskDone
        previewTaskText.text = taskPreview.taskText
    }
}