package com.study.labs

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lab2.*

class Lab2Activity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab2)

        button_add.setOnClickListener(this)
        button_copy.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button_add -> {
                textView1.text = textView1.text.toString() + "*"
            }
            R.id.button_copy -> {
                textView2.text = textView1.text
            }
        }
    }
}
