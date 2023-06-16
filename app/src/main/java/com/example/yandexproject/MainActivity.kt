package com.example.yandexproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yandexproject.recyclerview.TaskAdapter
import com.example.yandexproject.recyclerview.TasksPreviewRepository
import com.example.yandexproject.recyclerview.taskPreviewViewHolder
import android.view.View
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var tasksRecyclerView: RecyclerView
    private val tasksPreviewRepository = TasksPreviewRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button1 = findViewById<FloatingActionButton>(R.id.add_button)
        button1.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivity(intent)
        }

        tasksRecyclerView = findViewById(R.id.tasks)
        val tasksAdapter = TaskAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        tasksRecyclerView.adapter = tasksAdapter
        tasksRecyclerView.layoutManager = layoutManager
        tasksAdapter.tasks = tasksPreviewRepository.getTasks(this)
    }

}