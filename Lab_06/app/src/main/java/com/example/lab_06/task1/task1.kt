package com.example.lab_06.task1

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
fun main() {
    runBlocking {
        val job1 = async {
            repeat(10) {
                println("Job1 => ${it + 1}")
                delay(100)
            }
        }

        val job2 = GlobalScope.launch {
            repeat(10) {
                println("Job2 => ${it + 1}")
                delay(100)
            }
        }
    }
}