package com.study.labs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_lab15.*

class Lab15Activity : Lab15BaseActivity(), AdapterView.OnItemClickListener {
    private lateinit var adapter: Lab15Adapter
    private lateinit var array: MutableList<String>
    private lateinit var app: Lab17App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lab15)
        title = "Notes"

        app = applicationContext as Lab17App

        //array = mutableListOf()

        array = app.notes

        adapter = Lab15Adapter(array)
        list_view.adapter = adapter
        list_view.onItemClickListener = this

        button_add.setOnClickListener {
            val intent = Intent(this, Lab15SecondActivity::class.java)
            startActivityForResult(intent, CREATE_ACTION)
        }
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val root = view as LinearLayout?
        val tv = root?.findViewById<TextView>(R.id.text_item)

        val intent = Intent(this, Lab15SecondActivity::class.java)
        intent.putExtra(EXTRA_ID, position)
        intent.putExtra(EXTRA_TEXT, tv?.text.toString())
        startActivityForResult(intent, EDIT_ACTION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val ex = data?.extras
            val text = ex?.getString(EXTRA_TEXT)
            when (requestCode) {
                CREATE_ACTION -> {
                    adapter.list.add(text.toString())
                }
                EDIT_ACTION -> {
                    val id = ex?.getInt(EXTRA_ID)
                    adapter.list.removeAt(id!!)
                    adapter.list.add(id, text.toString())
                }
            }
            adapter.notifyDataSetChanged()
        }
        list_view.invalidateViews()
    }
}
