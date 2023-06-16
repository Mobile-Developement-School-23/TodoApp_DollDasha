package com.example.yandexproject

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import java.util.Calendar
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import androidx.core.content.ContentProviderCompat.requireContext

class AddTaskActivity : AppCompatActivity() {
    private lateinit var calendarButton: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        calendarButton = findViewById(R.id.calendar_button)
    }

    fun showDatePicker(view: View) {
        if (!calendarButton.isChecked) {
            calendarButton.text = "Сделать до"
            return
        }

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this,
            { _, selectedYear, selectedMonth, selectedDay ->
                calendarButton.text = "Сделать до " + "$selectedDay/${selectedMonth + 1}/$selectedYear"
            }, year, month, day)

        datePickerDialog.show()
    }
}