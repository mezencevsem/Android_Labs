package com.study.labs

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_lab15_second.*
import java.sql.Time

class Lab15SecondActivity : Lab15BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15_second)

        val arg = intent.extras
        if (arg != null) {
            val note = arg?.getSerializable(EXTRA_Note) as Note
            edit_text_title.setText(note.title)
            edit_text_description.setText(note.description)
        }

        edit_text_description.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                button_ok.isEnabled = edit_text_description.text.isNotEmpty()
            }
        })

        button_ok.setOnClickListener {
            val intent = intent
            intent.putExtra(EXTRA_Note,
                Note(
                    title = edit_text_title.text.toString(),
                    description = edit_text_description.text.toString(),
                    date = Time(System.currentTimeMillis())
                ))

            if (arg != null) intent.putExtra(EXTRA_ID, arg.getInt(EXTRA_ID))

            setResult(RESULT_OK, intent)
            finish()
        }

        button_cancel.setOnClickListener {
            setResult(0)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        button_ok.isEnabled = edit_text_description.text.isNotEmpty()
    }
}
