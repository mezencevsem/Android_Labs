package com.study.labs

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab12.*

class Lab12Activity : Lab12BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab12)

        button.setOnClickListener {
            startActivity(Intent(this, Lab12SecondActivity::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this, Lab12ThirdActivity::class.java))
        }
    }
}
