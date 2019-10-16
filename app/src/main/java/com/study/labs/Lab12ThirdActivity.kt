package com.study.labs

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lab12_third.*

class Lab12ThirdActivity : Lab12BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab12_third)

        button_back.setOnClickListener {
            onBackPressed()
        }
    }
}
