package com.example.lab_06.task2

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield
import java.lang.Thread.sleep

suspend fun factorial(num : Int) : Int {
    var fact : Int = 1
    for (iter in num downTo 2) {
        fact *= iter
        yield()
    }

    return fact
}

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val fact = async {
            println("Enter a number: ")
            factorial(readln().toInt())
        }
        println("Factorial = ${fact.await()}")
    }
}