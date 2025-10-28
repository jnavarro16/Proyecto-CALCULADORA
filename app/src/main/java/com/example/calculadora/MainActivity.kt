package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    CalculadoraApp()
                }
            }
        }
    }
}

@Composable
fun CalculadoraApp() {
    val calc = remember { Calculadora() }

    var pantalla by remember { mutableStateOf("") }
    var operador by remember { mutableStateOf<String?>(null) }
    var num1 by remember { mutableStateOf<Double?>(null) }

    //diseño
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "CALCULADORA",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(50.dp))

        Text(
            text = pantalla.ifEmpty { "0" },
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(Modifier.height(30.dp))

        //botones numeros y operadores
        val botones = listOf(
            listOf("C", "()", "%", "/"),
            listOf("7", "8", "9", "*"),
            listOf("4", "5", "6", "-"),
            listOf("1", "2", "3", "+"),
            listOf("", "0", ",", "=")
        )

        botones.forEach { fila ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                fila.forEach { text ->
                    Button(
                        onClick = {
                            //(switch)
                            when (text)
                            {
                                in "0".."9" -> pantalla += text

                                "C" -> {
                                    pantalla = ""
                                    operador = null
                                    num1 = null
                                }

                                "()" -> {
                                    pantalla = "("
                                }

                                "," -> {
                                    pantalla = pantalla+"."
                                }

                                "+", "-", "*", "/", "%" -> {
                                    if (pantalla.isNotEmpty()) {
                                        num1 = pantalla.toDouble()
                                        operador = text
                                        pantalla = ""
                                    }
                                }

                                //boton 'igual' funciona si hay algo pulsado
                                "=" -> {
                                    if (num1 != null && operador != null && pantalla.isNotEmpty()) {
                                        val num2 = pantalla.toDouble()
                                        val resultado = when (operador)
                                        {
                                            "+" -> calc.suma(num1!!, num2)
                                            "-" -> calc.resta(num1!!, num2)
                                            "*" -> calc.multiplicacion(num1!!, num2)
                                            "/" -> calc.division(num1!!, num2)
                                            "%" -> calc.porcentaje(num1!!, num2)
                                            else -> 0.0
                                        }
                                        pantalla = resultado.toString()
                                        operador = null
                                        num1 = null
                                    }
                                }
                            }
                        },
                        modifier = Modifier
                            .weight(1f)//distrubuye el espacio de botones
                            .padding(vertical = 8.dp)
                    ) {
                        Text(text, fontSize = 30.sp)
                    }
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview() {
    CalculadoraTheme {
        CalculadoraApp()
    }
}

