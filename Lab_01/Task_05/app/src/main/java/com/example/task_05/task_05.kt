package com.example.task_05

fun main() {
    print("Enter your first name: ")
    var firstName : String? = readLine()
    if (firstName != null) {
        if (firstName.isEmpty() || firstName.isBlank()) {
            firstName = null
        }
    }

    print("Enter your last name: ")
    var lastName : String? = readLine()
    if (lastName != null) {
        if (lastName.isEmpty() || lastName.isBlank()) {
            lastName = null
        }
    }

    println("${firstName ?: "You have not entered your 1st name"} \n ${lastName ?: "you have not entered your 2nd name"}")
}