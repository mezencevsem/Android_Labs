package com.study.labs

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_lab16.*

class Lab16Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab16)

        button_1.setOnClickListener {
            val toast = Toast.makeText(this, "Toast", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }

        button_2.setOnClickListener {
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(this, R.string.app_name, duration)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }

        button_3.setOnClickListener {
            val duration = Toast.LENGTH_LONG
            val toast = Toast.makeText(this, R.string.mafioznik, duration)
            toast.setGravity(Gravity.CENTER, 0, 0)
            val toastContainer = toast.view as LinearLayout
            toastContainer.gravity = Gravity.CENTER_HORIZONTAL
            val imageView = ImageView(this)
            imageView.setImageResource(R.drawable.image)
            toastContainer.addView(imageView, 0, ViewGroup.LayoutParams(500,500))
            toast.show()
        }

        button_4.setOnClickListener {
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.custom_toast,
                findViewById(R.id.custom_toast_container)
            )
            val toast = Toast(this)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            toast.view = layout
            toast.show()
        }

        button_5.setOnClickListener {
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.custom_toast,
                findViewById(R.id.custom_toast_container)
            )
            val toast = Toast(this)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            val imageView = layout.findViewById<ImageView>(R.id.image)
            imageView.setImageResource(R.drawable.photo)

            val text1 = layout.findViewById<TextView>(R.id.text_1)
            text1.text = "Семен"
            text1.setTextColor(ContextCompat.getColor(this, R.color.colorGreen))
            text1.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPurple))

            val text2 = layout.findViewById<TextView>(R.id.text_2)
            text2.text = "Мезенцев"
            text2.setTextColor(ContextCompat.getColor(this, R.color.colorBlue))
            text2.setBackgroundColor(ContextCompat.getColor(this, R.color.colorOrange))

            toast.view = layout
            toast.show()
        }

        button_6.setOnClickListener {
            val toastHelper = Lab16ToastHelper(this)
            toastHelper.show(edit_text_1.text.toString(),edit_text_2.text.toString())
        }
    }
}
