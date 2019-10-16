package com.study.labs

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

open class Lab12BaseActivity : AppCompatActivity() {
    protected lateinit var sp: SharedPreferences
    protected var mainColor = R.color.colorWhite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Выбор цвета"
        sp = getSharedPreferences("sp12", Context.MODE_PRIVATE)
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