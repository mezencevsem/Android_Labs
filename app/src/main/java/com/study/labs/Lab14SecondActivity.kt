package com.study.labs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab14_second.*

class Lab14SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab14_second)

        val arg = intent.extras

        if (arg != null) {
            val text1 = arg.get("text1") as CharSequence?
            val text2 = arg.get("text2") as CharSequence?
            if (text1 != null)  edit_text1.setText(text1)
            if (text2 != null)  edit_text2.setText(text2)
        }

        button_ok.setOnClickListener {
            val intent = intent
            intent.putExtra("text1", edit_text1.text as CharSequence?)
            intent.putExtra("text2", edit_text2.text as CharSequence?)
            setResult(1, intent)
            finish()
        }

        button_cancel.setOnClickListener {
            setResult(0)
            finish()
        }
    }
}
