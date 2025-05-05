package com.example.lab_06.task5

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() {
    runBlocking {
        val job1 = async {
            repeat(10) {
                println("Job1 => ${it + 1}")
                delay(100)
            }
        }

        job1.join()

        val job2 = launch {
            repeat(10) {
                println("Job2 => ${it + 1}")
                delay(100)
            }
        }

        delay(500)
        job2.cancelAndJoin()

        val job3 = launch {
            repeat(10) {
                println("Job3 => ${it + 1}")
                delay(100)
            }
        }
    }
}