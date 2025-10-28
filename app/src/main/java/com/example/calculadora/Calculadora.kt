package com.example.calculadora

class Calculadora
{
    fun suma(a: Int, b: Int): Int = a + b
    fun resta(a: Int, b: Int): Int = a - b
    fun multiplicacion(a: Int, b: Int): Int = a * b
    fun division(a: Int, b: Int): Double
    {
        if (b == 0) {
            throw IllegalArgumentException("No se puede dividir entre 0")
        }
        return a.toDouble() / b
    }
}