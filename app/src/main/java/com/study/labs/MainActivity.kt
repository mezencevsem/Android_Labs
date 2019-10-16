package com.study.labs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val labActivity = when(spinner.selectedItem.toString()){
                "1" -> Lab1Activity::class.java
                "2" -> Lab2Activity::class.java
                "3" -> Lab3Activity::class.java
                "4" -> Lab4Activity::class.java
                "5" -> Lab5Activity::class.java
                "6" -> Lab6Activity::class.java
                "7" -> Lab7Activity::class.java
                "8" -> Lab8Activity::class.java
                "9" -> Lab9Activity::class.java
                "10" -> Lab10Activity::class.java
                "11" -> Lab11Activity::class.java
                "12" -> Lab12Activity::class.java
                "13" -> Lab13Activity::class.java
                else -> null
            }

            startActivity(Intent(this, labActivity))
        }
    }
}
