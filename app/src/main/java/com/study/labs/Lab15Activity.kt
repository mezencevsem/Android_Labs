package com.study.labs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_lab15.*
import java.sql.Time

class Lab15Activity : Lab15BaseActivity(), AdapterView.OnItemClickListener {
    private lateinit var app: Lab17App
    private lateinit var array: MutableList<Note>
    private lateinit var adapter: Lab15Adapter
    private var editId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15)
        title = "Notes"

        app = applicationContext as Lab17App
        if (app.notes.size == 0) {
            app.testInsert("Title", "Description", Time(System.currentTimeMillis()).toString())
        }

        array = app.notes
        adapter = Lab15Adapter(array)
        list_view.adapter = adapter
        list_view.onItemClickListener = this

        button_add.setOnClickListener {
            val intent = Intent(this, Lab15SecondActivity::class.java)
            startActivityForResult(intent, CREATE_ACTION)
        }
    }

    override fun onResume() {
        super.onResume()
        app.showAllNotes()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val root = view as LinearLayout?
        val title = root?.findViewById<TextView>(R.id.text_title)?.text.toString()
        val description = root?.findViewById<TextView>(R.id.text_description)?.text.toString()
        val date = root?.findViewById<TextView>(R.id.text_date)?.text.toString()

        val intent = Intent(this, Lab15SecondActivity::class.java)

        editId = app.getNoteId(title = title, description = description, date = date)
        if (editId != null) {
            intent.putExtra(EXTRA_Note, Note(title = title, description = description, date = null))
            startActivityForResult(intent, EDIT_ACTION)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val ex = data?.extras
            val note = ex?.getSerializable(EXTRA_Note) as Note

            when (requestCode) {
                CREATE_ACTION -> {
                    app.addNote(title = note.title, description = note.description)
                }
                EDIT_ACTION -> {
                    app.editNote(
                        editId = editId!!,
                        title = note.title,
                        description = note.description
                    )
                }
            }
            app.showAllNotes()
            adapter.notifyDataSetChanged()
            list_view.invalidateViews()
        }
    }
}
