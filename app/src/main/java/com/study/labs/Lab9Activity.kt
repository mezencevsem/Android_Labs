package com.study.labs

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab9.*

class Lab9Activity : AppCompatActivity() {
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab9)

        sp = getSharedPreferences("sp", Context.MODE_PRIVATE)
    }

    override fun onPause() {
        super.onPause()

        val prefEditor = sp.edit()
        prefEditor.putString("key1", edit_text1.text.toString())
        prefEditor.putString("key2", edit_text2.text.toString())
        prefEditor.putInt("key3", edit_text3.text.toString().toInt())
        prefEditor.apply()
    }

    override fun onResume() {
        super.onResume()

        edit_text1.setText(sp.getString("key1",""))
        edit_text2.setText(sp.getString("key2",""))
        edit_text3.setText(sp.getInt("key3",0).toString())
    }
}
