package com.example.lab_05.task2

class Person() {
    lateinit var name : String
    lateinit var id : String
    lateinit var gender : String
}

fun main() {

    // receives this && not null safe && configures/initializes the object
    val person = Person().apply {
        name = "Juan"
        id = "86731"
        gender = "male"
    }

    // receives this && not null safe && operations on object that do not need chaining?!
    with(person) {
        println(name)
    }

    // receives this && not null safe && operations on object && returns a result
    person.run {
        println(id)
    }




}