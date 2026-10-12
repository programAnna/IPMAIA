package com.example.my_application

import android.os.Bundle
import android.widget.CheckedTextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.my_application.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProgramaPrincipal(
                        name = "Anna",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProgramaPrincipal(name: String, modifier: Modifier = Modifier) {
    val campoNome = remember { mutableStateOf("") }
    val checkbox1 = remember { mutableStateOf(false) }
    val campoTipo = remember { mutableStateOf("") }
    val checkbox2 = remember { mutableStateOf(false) }
    val campoIdade = remember { mutableStateOf("") }
    val campoSexo = remember { mutableStateOf("") }
    val checkbox3 = remember { mutableStateOf(false) }
    val campoAltura = remember { mutableStateOf("") }
    val campoNumero = remember { mutableStateOf("") }
    val checkbox4 = remember { mutableStateOf(false) }
    Text(
        text = "Olá, $name!",
        modifier = modifier
    )
    Column(modifier = modifier) {
        Row(modifier = modifier) {
            Text("Nome", modifier = modifier)
            TextField(
                value = campoNome.value,
                onValueChange = { campoNome.value = it },
                label = {},
                modifier = modifier
            )
            Checkbox(
                checked = checkbox1.value,
                onCheckedChange = { checkbox1.value = it },
                modifier = modifier
            )
        }
        Row(modifier = modifier) {
            Text("Tipo", modifier = modifier)
            TextField(
                value = campoTipo.value,
                onValueChange = { campoTipo.value = it },
                label = {},
                modifier = modifier
            )
            Checkbox(
                checked = checkbox2.value,
                onCheckedChange = { checkbox2.value = it },
                modifier = modifier
            )
        }
        Row(modifier = modifier) {
            TextField(
                value = campoIdade.value,
                onValueChange = {campoIdade.value = it},
                placeholder = {Text("Idade")},
                modifier = modifier
            )
            TextField(
                value = campoSexo.value,
                onValueChange = {campoSexo.value = it},
                placeholder = {Text("Sexo")},
                modifier = modifier
            )
            Checkbox(
                checked = checkbox3.value,
                onCheckedChange = { checkbox3.value = it},
                modifier = modifier
            )
        }
        Row(modifier = modifier) {
            TextField(
                value = campoAltura.value,
                onValueChange = {campoAltura.value = it},
                placeholder = {Text("Altura") },
                modifier = modifier
            )
            TextField(
                value = campoNumero.value,
                onValueChange = {campoNumero.value = it},
                placeholder = {Text("Numero")},
                modifier = modifier
            )
            Checkbox(
                checked = checkbox4.value,
                onCheckedChange = {checkbox4.value = it},
                modifier = modifier
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProgramaPrincipalPreview() {
    MyApplicationTheme {
        ProgramaPrincipal("Android")
    }
}