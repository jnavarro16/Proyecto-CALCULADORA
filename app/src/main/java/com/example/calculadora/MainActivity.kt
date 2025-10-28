package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun CalculadoraApp()
{

}

@Preview(showBackground = true)
@Composable
fun CalculadoraPreview()
{
    CalculadoraTheme {
        CalculadoraApp()
    }
}

