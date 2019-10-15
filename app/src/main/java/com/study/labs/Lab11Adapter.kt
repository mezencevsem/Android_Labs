package com.study.labs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat

class Lab11Adapter(val names: Array<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return names.size
    }

    override fun getItem(position: Int): Any {
        return names[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View? {
        var view = view
        val context = parent.context

        if (view == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_lab5, parent, false)
        }

        val textView = view as TextView?
        textView!!.text = names[position]

        val nextColor = when (textView.text) {
            "Red" -> R.color.colorRed
            "Orange" -> R.color.colorOrange
            "Yellow" -> R.color.colorYellow
            "Green" -> R.color.colorGreen
            "Light Blue" -> R.color.colorLightBlue
            "Blue" -> R.color.colorBlue
            "Purple" -> R.color.colorPurple
            "Pink" -> R.color.colorPink
            else -> R.color.colorWhite
        }
        textView.setBackgroundColor(ContextCompat.getColor(context, nextColor))
        return view
    }
}