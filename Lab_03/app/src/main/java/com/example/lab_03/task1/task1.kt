package com.example.lab_03.task1

enum class Building {
    VILLA,
    APARTMENT,
}

class Person (_name : String, _address : Address) {
    var name : String
    var address : Address
    init {
        name = _name
        address = _address
    }

    class Address (var streetName : String, var city : String, var building : Building) {
        override fun toString(): String {
            // return building.toString() + ", " + streetName + ", " + city
            return "$building, $streetName, $city"
        }
    }

    override fun toString(): String {
        return name
    }
}

fun main() {
    var person : Person = Person("Ahmed", Person.Address("14th of May", "Alexandria", Building.APARTMENT))

    println(person)
    println(person.address)
}