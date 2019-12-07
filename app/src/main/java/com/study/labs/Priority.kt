package com.study.labs

enum class Priority {
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
    }
}
