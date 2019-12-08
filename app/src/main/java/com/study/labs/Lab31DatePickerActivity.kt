package com.study.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab31_date_picker.*
import java.util.*

class Lab31DatePickerActivity : AppCompatActivity() {
    private lateinit var today: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab31_date_picker)
        title = "DatePicker"

        button_set_1.setOnClickListener {
            text_date_1.text = "${date_picker.dayOfMonth}:${date_picker.month + 1}:${date_picker.year}"
        }

        button_set_2.setOnClickListener {
            text_date_2.text = "${date_picker.dayOfMonth}:${date_picker.month + 1}:${date_picker.year}"
        }

        button_set_current_date.setOnClickListener {
            today = Calendar.getInstance()
            date_picker.init(
                today.get(Calendar.YEAR),
                today.get(Calendar.MONTH),
                today.get(Calendar.DAY_OF_MONTH),
                null)
        }
    }
}
