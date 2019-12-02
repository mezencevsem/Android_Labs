package com.study.labs

import java.io.Serializable
import java.sql.Time

class Note(val title: String, val description: String, val date: Time?) : Serializable