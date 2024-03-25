package com.example.firstactivity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstactivity.ui.theme.FirstActivityTheme
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstActivityTheme {
// A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Components(context = this)
                }
            }
        }
    }
}

@Composable
fun Components(context: Context) {
    var lsnome = remember {
        mutableStateOf("")
    }
    var lssenha = remember {
        mutableStateOf("")
    }
    var linumero = remember {
        mutableStateOf(15f)
    }

    var senhaVisivel = remember {
        mutableStateOf(false)
    }
    val decimalFormat = DecimalFormat("#")

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(10.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.paisagem),
            contentDescription = "Travell",
            modifier = Modifier
                .size(300.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )
        OutlinedTextField(value = lsnome.value, onValueChange = { lsnome.value = it }, label = {
            Text(text = "Login")
        }, modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        OutlinedTextField(
            value = lssenha.value,
            onValueChange = { lssenha.value = it },
            label = {
                Text(text = "Senha")
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation =
            if (senhaVisivel.value)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            trailingIcon = {
                IconButton(onClick = {
                    senhaVisivel.value = !senhaVisivel.value
                }) {
                    if (senhaVisivel.value) {
                        Icon(
                            painterResource(id = androidx.core.R.drawable.ic_call_decline), ""
                        )
                    } else {
                        Icon(
                            painterResource(id = androidx.core.R.drawable.ic_call_answer), ""
                        )
                    }
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Button(
            onClick = {
                if (lsnome.value == "admin" && lssenha.value == "123") {
                    Toast.makeText(context, "Sucesso!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Login ou usuário incorreto!", Toast.LENGTH_SHORT)
                        .show()
                }
            }, modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Login")
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstActivityTheme {
        Greeting("Android")
    }
}