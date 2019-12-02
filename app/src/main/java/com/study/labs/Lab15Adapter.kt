package com.study.labs

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*

class Lab15Adapter(val list: MutableList<Note>) : BaseAdapter() {
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
        val random = Random()
        var view = view
        val context = parent.context
        app = context.applicationContext as Lab17App

        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_lab19, parent, false)
            val colorBox = view?.findViewById<ColoredView>(R.id.color_box)
            colorBox?.setColor(Color.rgb(random.nextInt(255), random.nextInt(255), random.nextInt(255)))
        }

        //val tv = view as TextView?
        //tv!!.text = list[position]


        val title = view?.findViewById<TextView>(R.id.text_title)
        title?.text = list[position].title

        val description = view?.findViewById<TextView>(R.id.text_description)
        description?.text = list[position].description

        val date = view?.findViewById<TextView>(R.id.text_date)
        date?.text = list[position].date.toString()

        return view
    }
}