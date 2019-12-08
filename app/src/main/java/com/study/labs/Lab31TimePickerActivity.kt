package com.study.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab31_time_picker.*
import java.util.*

class Lab31TimePickerActivity : AppCompatActivity() {
    private lateinit var today: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab31_time_picker)
        title = "TimePicker"

        time_picker.setIs24HourView(true)

        button_set_1.setOnClickListener {
            text_time_1.text = "${time_picker.currentHour}:${time_picker.currentMinute}"
        }

        button_set_2.setOnClickListener {
            text_time_2.text = "${time_picker.currentHour}:${time_picker.currentMinute}"
        }

        button_set_current_time.setOnClickListener {
            today = Calendar.getInstance()
            //TODO not work!
            time_picker.currentMinute = today.get(Calendar.MINUTE)
            time_picker.currentHour = today.get(Calendar.HOUR_OF_DAY)
        }
    }
}
