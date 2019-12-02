package com.study.labs

import android.app.Application

class Lab17App(
    var text_1: String = "text_1",
    var text_2: String = "text_2",
    var notes: ArrayList<String> = ArrayList()) : Application(){

    init {
        notes.add("Record 1")
        notes.add("Record 2")
    }
}