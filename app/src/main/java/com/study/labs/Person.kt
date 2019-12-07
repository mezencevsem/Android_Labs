package com.study.labs

class Person(val name: String, val age: Int, val sex: Sex, val status: Status) {

    override fun toString(): String {
        return "$name $age y.o. ($sex, $status)"
    }
}