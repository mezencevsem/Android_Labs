package com.study.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab10.*

class Lab10Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab10)

        val adapter = Lab10Adapter(resources.getStringArray(R.array.labs))
        list_view.adapter = adapter
    }
}
