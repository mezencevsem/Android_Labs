package com.study.labs

import android.content.Context
import android.util.AttributeSet
import android.view.View

class ColoredView(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    fun setColor(color: Int) {
        this.setBackgroundColor(color)
    }
}