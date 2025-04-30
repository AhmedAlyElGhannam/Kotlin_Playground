package com.example.lab_04.task1

import kotlin.math.abs

class Complex(_real : Double = 0.0, _img : Double = 0.0)  {
    var real : Double
    var img : Double

    init {
        real = _real
        img = _img
    }

    override fun toString() : String {
        var str : String = ""

        if (this.real != 0.0) {
            str += real
        }

        if (this.img > 0.0) {
            str += " + ${abs(img)}i"
        }
        else if (this.img < 0.0) {
            str += " - ${abs(img)}i"
        }

        if ((this.real == 0.0) && (this.img == 0.0)) {
            str = "0.0"
        }

        return str
    }
}

infix operator fun Complex.plus(complex : Complex) : Complex {
    return Complex(this.real + complex.real, this.img + complex.img)
}

infix operator fun Complex.minus(complex : Complex) : Complex {
    return Complex(this.real - complex.real, this.img - complex.img)
}

fun Complex.printComplex() {
    println(this.toString())
}

fun main() {
    var complex1 : Complex = Complex(-9.0, -8.0)
    var complex2 : Complex = Complex(9.0, 0.0)

    complex1.printComplex()
    complex2.printComplex()

    println((complex1 + complex2).toString())
    println((complex1 - complex2).toString())

}