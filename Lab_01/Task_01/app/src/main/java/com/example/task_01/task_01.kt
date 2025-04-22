package com.example.task_01

import java.util.Random

fun main() {
    val size = 100;
    val min = 1;
    val max = 100;
    var arr : IntArray = IntArray(size);
    var i : Int = 0;
    repeat(size) {
        arr.set(i, Random().nextInt(max - min) + min);
        if (arr[i] < 10) {
            println("Element $i equals ${arr.get(i)}");
        }
        i++;
    }


}