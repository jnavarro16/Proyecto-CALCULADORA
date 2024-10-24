package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    // Declaramos Variables de los elementos
    val entrada = StringBuilder() // almacena los números y operadores ingresados
    lateinit var textoCuadro: TextView // variable para el cuadro de texto

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_vertical)

        // Inicializamos el TextView donde se mostrará la entrada
        textoCuadro = findViewById(R.id.textoCuadro)

        // Botones numéricos para agregar números a la entrada
        findViewById<Button>(R.id.button0).setOnClickListener {
            agregarNumero("0")
        }
        findViewById<Button>(R.id.button1).setOnClickListener {
            agregarNumero("1")
        }
        findViewById<Button>(R.id.button2).setOnClickListener {
            agregarNumero("2")
        }
        findViewById<Button>(R.id.button3).setOnClickListener {
            agregarNumero("3")
        }
        findViewById<Button>(R.id.button4).setOnClickListener {
            agregarNumero("4")
        }
        findViewById<Button>(R.id.button5).setOnClickListener {
            agregarNumero("5")
        }
        findViewById<Button>(R.id.button6).setOnClickListener {
            agregarNumero("6")
        }
        findViewById<Button>(R.id.button7).setOnClickListener {
            agregarNumero("7")
        }
        findViewById<Button>(R.id.button8).setOnClickListener {
            agregarNumero("8")
        }
        findViewById<Button>(R.id.button9).setOnClickListener {
            agregarNumero("9")
        }

        // Botones de operaciones:
        // Botón para la suma
        findViewById<Button>(R.id.buttonSuma).setOnClickListener {
            agregarNumero("+")
        }
        // Botón para limpiar
        findViewById<Button>(R.id.buttonC).setOnClickListener {
            clean()
        }
        // Botón para calcular el resultado
        findViewById<Button>(R.id.buttonIgual).setOnClickListener {
            val resultado =
            calcular(entrada.toString())
            textoCuadro.text = resultado.toString()
        }
    }

    // Método para agregar los numeros o los operadores al cuadro de texto
    fun agregarNumero(numero: String) {
        entrada.append(numero)  // añadimos el argumento a la entrada
        textoCuadro.text = entrada.toString() // Lo mostramos en el texto
    }

    // Método para limpiar el cuadro de texto
    fun clean() {
        entrada.clear() // Borra la entrada
        textoCuadro.text = "" // Limpia el TextView
    }

    fun calcular(string: String): Int
    {
        if (!string.contains("+")) {
            return string.toInt()
        } else {
            // Divide la cadena
            val parts = string.split("+", limit = 2)
            val string1 = parts[0]
            val string2 = parts[1]
            return calcular(string1) + calcular(string2)
        }
    }

}

