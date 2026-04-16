package com.example.lab_04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab_04.ui.theme.Lab_04Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab_04Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var texto by remember { mutableStateOf("Hello $name!") }
    var checked by remember { mutableStateOf(false) }
    var textoInput by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = texto,
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                texto = "¡Botón mejorado!"
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .padding(8.dp)
        ) {
            Text("Botón Mejorado")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it }
        )

        Text(
            text = if (checked) "Checkbox activado" else "Checkbox desactivado"
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = textoInput,
            onValueChange = { textoInput = it },
            label = { Text("Escribe algo") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Texto ingresado: $textoInput")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab_04Theme {
        Greeting("Android")
    }
}