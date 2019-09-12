package com.study.labs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lab6.*

class Lab6Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab6)

        button_second_act.setOnClickListener(this)
        button_third_act.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val nextActivity = when (v?.id) {
            R.id.button_second_act -> Lab6SecondActivity::class.java
            R.id.button_third_act -> Lab6ThirdActivity::class.java
            else -> null
        }
        startActivity(Intent(this, nextActivity))
    }
}
