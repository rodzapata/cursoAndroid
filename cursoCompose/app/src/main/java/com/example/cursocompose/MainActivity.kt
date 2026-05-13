package com.example.cursocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursocompose.ui.theme.CursoComposeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoComposeTheme {
                GetSpacer()
                //GetIcon()
                //GetString()
                //GetImagen()
                //GetBotones()
                //GetScaffold()
                //GetSurface()

            }
        }
    }
}


@Composable
fun GetSpacer(
) {
    Column(
        modifier = Modifier.padding(vertical = 64.dp)

    ) {
        Text(
            text = "texto 1"
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "texto 2"
        )
    }

    Row(
        modifier = Modifier.padding(vertical = 132.dp)

    ) {
        Text(
            text = "columna 1"
        )
        Spacer(Modifier.width(45.dp))
        Text(
            text = "columna 2"
        )
    }
}

@Composable
fun GetIcon() {
    Column(
        modifier = Modifier.padding(vertical = 64.dp)
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            modifier = Modifier
                .size(35.dp),
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun GetString() {
    val message = stringResource(R.string.happy_birthday_text)
    val fromText = stringResource(R.string.signature_from_text)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = message,
            fontSize = 100.sp,
            lineHeight = 116.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = fromText,
            fontSize = 36.sp,
            modifier = Modifier
                .align(alignment = Alignment.End)
        )
    }
}


@Composable
fun GetImagen() {
    Box(
        modifier = Modifier
            .padding(vertical = 64.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = null,
            modifier = Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Green, CircleShape),
            contentScale = ContentScale.Crop
        )

    }
}

@Composable
fun GetBotones() {
    Column(
        modifier = Modifier
            .padding(vertical = 50.dp)
            .padding(horizontal = 12.dp)
    ) {
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
        ) {
            Text("Inicio")
        }

        Button(
            onClick = {}
        ) {
            Icon(Icons.Default.Person, "Persona")
            Text("Personalizado")
        }

        OutlinedButton(onClick = {}

        ) {
            Text("Cancelar")
        }

        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.background,
                contentColor = MaterialTheme.colorScheme.primary
            ),
            shape = RoundedCornerShape(15.dp),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
            modifier = Modifier
                .shadow(4.dp, RoundedCornerShape(15.dp))

        ) {
            Icon(
                Icons.Default.Favorite, "favorito",
                modifier = Modifier.size(25.dp)
            )
            Text("favorito")
        }

        TextButton(
            onClick = {}
        ) {
            Text("Olvide mi contraseña")
        }

        IconButton(
            onClick = { }
        ) {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
            )
        }

        FloatingActionButton(
            onClick = {}
        ) {
            Icon(
                Icons.Default.Add, null
            )
        }

        FilledTonalButton(
            onClick = {}
        ) {
            Text("filtrar")
        }
    }
}

@Composable
fun GetSurface() {
    //val image = painterResource(R.drawable.logo_actual)
    val image = painterResource(R.drawable.fondo)
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(

        ) {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                /*
                modifier =
                    Modifier.fillMaxSize()

                 */
            )

            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                //horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Happy Birthday Sam",
                    fontSize = 100.sp,
                    lineHeight = 116.sp,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "from Rodney",
                    fontSize = 36.sp,
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                )
            }

        }
    }
}

@Composable
fun GetScaffold() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {}) {
            Text(text = "Prueba")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CursoComposeTheme {
        Greeting("Android")
    }
}