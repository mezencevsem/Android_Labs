package com.study.labs

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_lab11.*

class Lab11Activity : AppCompatActivity() {
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab11)
        title = "Выбор цвета"

        sp = getSharedPreferences("sp11", Context.MODE_PRIVATE)

        button.setOnClickListener {
            startActivity(Intent(this, Lab11SecondActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        window.decorView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                sp.getInt("mainColor", R.color.colorWhite)
            )
        )
    }
}
