package com.study.labs

import java.io.Serializable

enum class Priority : Serializable {
    High,
    Medium,
    Low;

    companion object {
        fun valueOf(ordinal: Int): Priority {
            for (item in values()) {
                if (item.ordinal == ordinal) {
                    return item
                }
            }
            throw IllegalArgumentException()
        }

        fun getItemsArray(): MutableList<String> {
            val array = mutableListOf<String>()
            for (item in values()) {
                array.add(item.name)
            }
            return array
        }
    }
}
