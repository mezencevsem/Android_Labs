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

    fun addNote(text: String) {
        val toastHelper = Lab20ToastHelper(this)
        notes.add(text)
        toastHelper.show(resources.getString(R.string.create_note))
    }

    fun editNote(id: Int, text: String) {
        val toastHelper = Lab20ToastHelper(this)
        notes.removeAt(id)
        notes.add(id, text)
        toastHelper.show(resources.getString(R.string.edit_note))
    }
}