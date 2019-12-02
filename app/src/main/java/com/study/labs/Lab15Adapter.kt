package com.study.labs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class Lab15Adapter(val list: MutableList<String>) : BaseAdapter() {
    private lateinit var app: Lab17App

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View? {
        var view = view
        val context = parent.context
        app = context.applicationContext as Lab17App

        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_lab19, parent, false)
        }

        /*val tv = view as TextView?
        tv!!.text = list[position]
        */

        val tv = view?.findViewById<TextView>(R.id.text_item)
        tv?.text = list[position]

        return view
    }
}