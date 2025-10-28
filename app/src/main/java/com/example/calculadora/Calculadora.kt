package com.example.calculadora

class Calculadora {
    fun suma(a: Double, b: Double): Double = a + b
    fun resta(a: Double, b: Double): Double = a - b
    fun multiplicacion(a: Double, b: Double): Double = a * b
    fun division(a: Double, b: Double): Double {
        if (b == 0.0) {
            throw IllegalArgumentException("No se puede dividir entre 0")
        }
        return a / b
    }
}