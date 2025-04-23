package com.example.lab_02.task1

abstract class Shape() {
    var dim : Int = 0
        set(value) {
            field = if (value > 0) value else 0
        }
        get() {
            return field
        }
    constructor(passedDim : Int) : this() {dim = passedDim}
    abstract fun calcArea() : Double
}

class Circle(radius : Int) : Shape(radius) {
    override fun calcArea(): Double {
        return (dim * dim * 3.14)
    }

}

class Rectangle(dim1 : Int, _dim2 : Int) : Shape(dim1) {
    var dim2 : Int = 0
    init {
        dim2 = _dim2
    }
    override fun calcArea(): Double {
        return (dim * dim2 * 1.0)
    }
}

class Triangle(dim1 : Int, var dim2 : Int) : Shape(dim1) {
    override fun calcArea(): Double {
        return (dim * dim2 * 0.5)
    }
}

class Picture {
    companion object {
        fun sumAreas(s1 : Shape, s2 : Shape, s3 : Shape) : Double {
            return (s1.calcArea() + s2.calcArea() + s3.calcArea())
        }
    }
}

fun main() {
    val circle : Circle = Circle(10)
    val rect : Rectangle = Rectangle(50, 20)
    val tri : Triangle = Triangle(100, 2)

    println("Area = " + Picture.sumAreas(circle, rect, tri))
}
