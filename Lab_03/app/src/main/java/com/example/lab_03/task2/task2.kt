package com.example.lab_03.task2

interface NumberSeries {
    var start : Int
    var current : Int
    val step : Int
    fun reset()
    fun getNext() : Int
}

class ByThree : NumberSeries {

    override var start: Int = 0
    override var current: Int = 0
    override val step: Int = 3

    override fun reset() {
        current = start
    }

    override fun getNext(): Int {
        current += step
        return current
    }

}

fun main() {
    val series : NumberSeries = ByThree()

    repeat(10) {
        series.getNext()
    }

    println(series.getNext())
}