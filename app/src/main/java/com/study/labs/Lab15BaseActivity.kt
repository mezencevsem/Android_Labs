package com.study.labs

import androidx.appcompat.app.AppCompatActivity

abstract class Lab15BaseActivity : AppCompatActivity() {
    protected val CREATE_ACTION = 0x000312
    protected val EDIT_ACTION = 0x000313
    protected val EXTRA_TEXT = "text"
    protected val EXTRA_ID = "id"
    protected val RESULT_OK= 1
}