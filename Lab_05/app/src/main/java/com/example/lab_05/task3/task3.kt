package com.example.lab_05.task3

val add = {x : Double, y : Double -> x + y}
val sub = {x : Double, y : Double -> x - y}
val mul = {x : Double, y : Double -> x * y}
val div = {x : Double, y : Double ->
    if (y == 0.0) {
        0.0
    }
    else {
        x / y
    }
}

fun calculatorUsingLambda(x : Double, y : Double, op : (Double, Double) -> Double) : Double {
    return op.invoke(x, y)
}

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
                    1 -> println(calculatorUsingLambda(num1, num2, add))
                    2 -> println(calculatorUsingLambda(num1, num2, sub))
                    3 -> println(calculatorUsingLambda(num1, num2, mul))
                    4 -> println(calculatorUsingLambda(num1, num2, div))
                }
            }
        }
    }
}