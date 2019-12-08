package com.study.labs

import java.io.Serializable

class Note(val title: String, val description: String, val date: Long, val priority: Priority) :
    Serializable