package com.study.labs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab31.*

class Lab31Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab31)

        button_1.setOnClickListener {
            startActivity(Intent(this, Lab31DatePickerActivity::class.java))
        }

        button_2.setOnClickListener {
            startActivity(Intent(this, Lab31TimePickerActivity::class.java))
        }
    }
}
