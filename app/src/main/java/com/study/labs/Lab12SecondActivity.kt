package com.study.labs

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_lab12_second.*

class Lab12SecondActivity : Lab12BaseActivity(), AdapterView.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab12_second)

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
        window.decorView.setBackgroundColor(ContextCompat.getColor(this, mainColor))

        val prefEditor = sp.edit()
        prefEditor.putInt("mainColor", mainColor)
        prefEditor.apply()
    }
}
