package com.example.lab_06.task3

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


fun main() {
    runBlocking {
        val job1 = withTimeoutOrNull(10000) {
            repeat(300) {
                println("Hola from job1 -> $it")
                delay(100)
            }
        }

        val job2 = withTimeoutOrNull(10000) {
            repeat(450) {
                println("Bonjour from job2 -> $it")
                delay(75)
            }
        }

        if (job1 == null) {
            println("Job1 cancelled")
        }

        if (job2 == null) {
            println("Job2 cancelled")
        }
    }
}