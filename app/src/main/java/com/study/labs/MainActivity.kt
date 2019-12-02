package com.study.labs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_debug.setOnClickListener {
            startActivity(Intent(this, Lab15Activity::class.java))
        }
        
        button.setOnClickListener {
            val labActivity = when (spinner.selectedItem.toString()) {
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
                "14" -> Lab14Activity::class.java
                "15" -> Lab15Activity::class.java
                "16" -> Lab16Activity::class.java
                "17" -> Lab17Activity::class.java
                "18" -> Lab18Activity::class.java
                //"19" -> Lab19Activity::class.java
                //"20" -> Lab20Activity::class.java
                //"21" -> Lab21Activity::class.java
                //"22" -> Lab22Activity::class.java
                //"23" -> Lab23Activity::class.java
                //"24" -> Lab24Activity::class.java
                //"25" -> Lab25Activity::class.java
                //"26" -> Lab26Activity::class.java
                //"27" -> Lab27Activity::class.java
                //"28" -> Lab28Activity::class.java
                //"29" -> Lab29Activity::class.java
                //"30" -> Lab30Activity::class.java
                //"31" -> Lab31Activity::class.java
                //"32" -> Lab32Activity::class.java
                //"33" -> Lab33Activity::class.java
                //"34" -> Lab34Activity::class.java
                else -> null
            }

            startActivity(Intent(this, labActivity))
        }
    }
}
