package com.study.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab7.*

class Lab7Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab7)

        button.setOnClickListener {
            startActivity(Intent(this, Lab7SecondActivity::class.java))
        }
    }
}
