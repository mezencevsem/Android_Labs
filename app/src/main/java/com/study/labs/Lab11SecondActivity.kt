package com.study.labs

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_lab11_second.*

class Lab11SecondActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private lateinit var sp: SharedPreferences
    private var mainColor = R.color.colorWhite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab11_second)
        title = "Выбор цвета"

        sp = getSharedPreferences("sp11", Context.MODE_PRIVATE)

        window.decorView.setBackgroundColor(
            ContextCompat.getColor(
                this,
                sp.getInt("mainColor", R.color.colorWhite)
            )
        )

        val adapter = Lab11Adapter(resources.getStringArray(R.array.colors_names))
        list_view.adapter = adapter
        list_view.onItemClickListener = this
        button_back.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        mainColor = when (position) {
            0 -> R.color.colorRed
            1 -> R.color.colorOrange
            2 -> R.color.colorYellow
            3 -> R.color.colorGreen
            4 -> R.color.colorLightBlue
            5 -> R.color.colorBlue
            6 -> R.color.colorPurple
            7 -> R.color.colorPink
            else -> R.color.colorWhite
        }
        layout.setBackgroundColor(ContextCompat.getColor(this, mainColor))

        val prefEditor = sp.edit()
        prefEditor.putInt("mainColor", mainColor)
        prefEditor.apply()
    }
}
