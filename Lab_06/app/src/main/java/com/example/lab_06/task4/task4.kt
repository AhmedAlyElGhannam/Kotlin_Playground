package com.example.lab_06.task4

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.yield


suspend fun sumArr(nums : ArrayList<Int>) : Int {
    var sum : Int = 0
    repeat(nums.size) {
        sum += nums[it]
        yield()
    }

    return sum
}

fun main() {
    runBlocking {
        val sum = async {
            println("Enter a number of element: ")
            val sizeArr = readln().toInt()
            var arr = ArrayList<Int>()
            repeat(sizeArr) {
                println("Enter element of index $it: ")
                arr.add(readln().toInt())
            }
            sumArr(arr)
        }
        println("Sum = ${sum.await()}")
    }
}