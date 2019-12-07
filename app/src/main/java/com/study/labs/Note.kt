package com.study.labs

import java.io.Serializable

class Note(val title: String, val description: String, val date: String?, val priority: Priority) : Serializable