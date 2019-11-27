package com.study.labs

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_lab15_second.*

class Lab15SecondActivity : Lab15BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15_second)

        button_ok.isEnabled = edit_text.text.isNotEmpty()

        val arg = intent.extras
        edit_text.setText(arg?.getString(EXTRA_TEXT))

        edit_text.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button_ok.isEnabled = edit_text.text.isNotEmpty()
            }
        })

        button_ok.setOnClickListener {
            val intent = intent
            intent.putExtra(EXTRA_TEXT, edit_text.text.toString())
            if (arg != null){
                intent.putExtra(EXTRA_ID, arg.getInt(EXTRA_ID))
                setResult(RESULT_OK, intent)
            } else {
                setResult(RESULT_OK, intent)
            }
            finish()
        }

        button_cancel.setOnClickListener {
            setResult(0)
            finish()
        }
    }
}
