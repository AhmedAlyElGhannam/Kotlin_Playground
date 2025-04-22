package com.example.task_03

fun main() {
    println("Enter the 1st number: ")
    val num1 : Double? = readLine()?.toDoubleOrNull()
    if (num1 == null) {
        println("Invalid 1st number!")
    }
    else {
        println("Enter the 2nd number: ")
        val num2 : Double? = readLine()?.toDoubleOrNull()
        if (num2 == null) {
            println("Invalid 2nd number!")
        }
        else {
            println("Enter the number corresponding to the operation: ")
            println("1. Addition")
            println("2. Subtraction")
            println("3. Multiplication")
            println("4. Division")
            val op : Int? = readLine()?.toIntOrNull() ?: return
            if (op == null) {
                println("Invalid operation!")
            }
            else {
                when (op) {
                    1 -> println("$num1 + $num2 = ${num1 + num2}")
                    2 -> println("$num1 - $num2 = ${num1 - num2}")
                    3 -> println("$num1 * $num2 = ${num1 * num2}")
                    4 -> if (num2.toInt() != 0) { println("$num1 / $num2 = ${num1 / num2}") }
                         else { println("Cannot divide by 0!") }
                    else -> println("Invalid Operator!")
                }
            }
        }
    }
}