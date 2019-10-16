package com.study.labs

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_lab14.*

class Lab14Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab14)

        button.setOnClickListener {
            val intent = Intent(this, Lab14SecondActivity::class.java)
            intent.putExtra("text1", edit_text1.text)
            intent.putExtra("text2", edit_text2.text)
            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == 1) {
            val ex = data?.extras
            edit_text1.setText(ex?.get("text1") as CharSequence?)
            edit_text2.setText(ex?.get("text2") as CharSequence?)
        }
    }
}
