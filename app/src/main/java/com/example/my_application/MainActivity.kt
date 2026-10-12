package com.example.my_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.my_application.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ProgramaPrincipal(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ProgramaPrincipal(name: String, modifier: Modifier = Modifier) {
    val valorNome = rememberSaveable {mutableStateOf("")}
    val valorTipo = rememberSaveable {mutableStateOf("")}
    val valorIdade = rememberSaveable {mutableStateOf("")}
    val checkbox1 = rememberSaveable { mutableStateOf(false)} // sobrevive a uma rotação
    val checkbox2 = remember { mutableStateOf(false)} // não sobrevive a uma rotação
    val checkbox3 = remember { mutableStateOf(false)} // não sobrevive a uma rotação
    val checkbox4 = remember { mutableStateOf(false)} // não sobrevive a uma rotação
    val valorSexo =  rememberSaveable {mutableStateOf("")}
    val valorNumero =  rememberSaveable {mutableStateOf("")}
    val valorAltura =  rememberSaveable {mutableStateOf("")}
    Column() {
        Row(modifier = Modifier.padding(4.dp)) {
            Row(Modifier.weight(0.8f)) {
                Text("Nome", modifier = modifier.padding(4.dp))
                TextField(value = valorNome.value, onValueChange = { valorNome.value = it }, modifier = modifier)
            }
            Checkbox(checked = checkbox1.value, onCheckedChange = { checkbox1.value = it}, modifier=modifier.weight(0.2f))
        }
        Row(modifier = Modifier.padding(4.dp)) {
            Row(Modifier.weight(0.8f)) {
                Text("Tipo", modifier = Modifier.padding(4.dp))
                TextField(value = valorTipo.value, onValueChange = { valorTipo.value = it },
                    label = { Text("coloque o tipo") }, modifier = Modifier
                )
            }
            Checkbox(checked = checkbox2.value, onCheckedChange = { checkbox2.value = it}, modifier=Modifier.weight(0.2f))
        }
        Row(modifier = Modifier.padding(4.dp)) {
            TextField(value = valorIdade.value, onValueChange = {valorIdade.value = it}, placeholder = {Text("Idade")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.padding(4.dp).weight(0.4f))
            TextField(value = valorSexo.value, onValueChange = {valorSexo.value = it}, placeholder = {Text("Sexo")},
                modifier = Modifier.weight(0.4f))
            Checkbox(checked = checkbox3.value, onCheckedChange = { checkbox3.value = it}, modifier=Modifier.weight(0.2f))
        }
        Row(modifier = Modifier.padding(4.dp)) {
            TextField(value = valorAltura.value, onValueChange = {valorAltura.value = it}, placeholder = {Text("Altura")},
                modifier = Modifier.padding(4.dp).weight(0.4f))
            TextField(value = valorNumero.value, onValueChange = {valorNumero.value = it}, placeholder = {Text("Número")},
                modifier = Modifier.weight(0.4f))
            Checkbox(checked = checkbox4.value, onCheckedChange = { checkbox4.value = it}, modifier=Modifier.weight(0.2f))
        }
        Box(modifier = Modifier.size(20.dp).background(Color.Red))
    }
}

@Preview(showBackground = true)
@Composable
fun EcraPreview() {
    MyApplicationTheme {
        ProgramaPrincipal("Android")
    }
}