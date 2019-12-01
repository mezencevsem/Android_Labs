package com.study.labs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab17.*

class Lab17Activity : AppCompatActivity() {
    private lateinit var app : Lab17App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab17)

        app = applicationContext as Lab17App

        val text1 = resources.getText(R.string.app_name)
        val text2= resources.getText(R.string.mafioznik)

        app.text_1 = text1.toString()
        app.text_2 = text2.toString()

        edit_text1.setText(app.text_1)
        edit_text2.setText(app.text_2)

        button.setOnClickListener {
            app.text_1 = edit_text1.text.toString()
            app.text_2 = edit_text2.text.toString()
            startActivityForResult(Intent(this, Lab17SecondActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 2 && requestCode == 1) {
            edit_text1.setText(app.text_1)
            edit_text2.setText(app.text_2)
        }
    }
}
