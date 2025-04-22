package com.example.task_04

fun main() {
    print("Enter a number of lines for the pyramids (1 or more): ")
    val numLines : Int? = readLine()?.toIntOrNull()
    if (numLines == null) {
        println("Invalid input! Try again!")
    }
    else if (numLines < 1)
    {
        println("Invalid number! Try again!")
    }
    else {
        for (i in 1..numLines) {
            for (j in 0 until (numLines * 2)) {
                if (j < i) {
                    print("*")
                }
                else {
                    // print nothing
                }
            }

            for (k in (3 * numLines - 1) downTo 0) {
                if (k < (2 * i - 1)) {
                    if (k % 2 == 0) {
                        print("*")
                    }
                    else {
                        print(" ")
                    }
                }
                else {
                    print(" ")
                }
            }

            print("\n")
        }
    }

}
