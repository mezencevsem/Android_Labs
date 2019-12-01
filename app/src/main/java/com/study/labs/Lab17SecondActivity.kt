package com.study.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab17_second.*

class Lab17SecondActivity : AppCompatActivity() {
    private lateinit var app: Lab17App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab17_second)

        app = applicationContext as Lab17App

        edit_text1.setText(app.text_1)
        edit_text2.setText(app.text_2)

        button_ok.setOnClickListener {
            app.text_1 = edit_text1.text.toString()
            app.text_2 = edit_text2.text.toString()
            setResult(2)
            finish()
        }
    }
}
