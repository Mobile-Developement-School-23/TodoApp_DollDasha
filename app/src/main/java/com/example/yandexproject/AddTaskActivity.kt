package com.example.yandexproject

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import java.util.Calendar
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Spinner
import android.widget.Switch
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputLayout

class AddTaskActivity : AppCompatActivity() {
    private lateinit var calendarButton: Switch
    private lateinit var autoCompleteTextView: AutoCompleteTextView
    private lateinit var closeButton: FloatingActionButton
    private lateinit var saveButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        closeButton = findViewById(R.id.close_button)
        closeButton.setOnClickListener{
            finish()
        }

        saveButton = findViewById(R.id.save_button)
        saveButton.setOnClickListener{
            finish()
        }

        calendarButton = findViewById(R.id.calendar_button)
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView)
        autoCompleteTextView.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.popup_menu) // Здесь используется файл ресурсов menu/popup_menu.xml

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.importance_1 -> {
                    val text = "Нет"
                    autoCompleteTextView.text = SpannableStringBuilder.valueOf(text) as Editable
                    true
                }
                R.id.importance_2 -> {
                    val text = "Низкий"
                    autoCompleteTextView.text = SpannableStringBuilder.valueOf(text) as Editable
                    true
                }
                R.id.importance_3 -> {
                    val text = "Высокий"
                    autoCompleteTextView.text = SpannableStringBuilder.valueOf(text) as Editable
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
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