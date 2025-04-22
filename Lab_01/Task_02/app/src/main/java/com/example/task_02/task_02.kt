package com.example.task_02

fun main() {
    print("Enter your name: ")
    var name : String? = readLine()
    if (name.isNullOrBlank()) {
        name = "Keiner"
    }
    println("Hello $name")
}