package com.study.labs

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.util.*

class Lab15Adapter(private val list: MutableList<Note>) : BaseAdapter() {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, View: View?, parent: ViewGroup): View? {
        val random = Random()
        var view = View
        val context = parent.context

        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_lab19, parent, false)

            val colorBox = view?.findViewById<ColoredView>(R.id.color_box)
            colorBox?.setColor(
                Color.rgb(
                    random.nextInt(255),
                    random.nextInt(255),
                    random.nextInt(255)
                )
            )
        }

        val title = view?.findViewById<TextView>(R.id.text_title)
        title?.text = list[position].title

        val description = view?.findViewById<TextView>(R.id.text_description)
        description?.text = list[position].description

        val date = view?.findViewById<TextView>(R.id.text_date)
        val today = Calendar.getInstance()
        today.timeInMillis = list[position].date
        date?.text = today.time.toString()

        val priority = view?.findViewById<TextView>(R.id.text_priority)
        priority?.text = list[position].priority.name

        return view
    }
}
