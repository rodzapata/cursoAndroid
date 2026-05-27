package com.example.cursocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
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
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                GetBox()
                //GetColumn()
                //ComposeQuadrantApp()
                // FourQuadrantsScreen()
                //CuadranteCompose()
                //EndTask()
                //ComposeArticulo()
                //GetSpacer()
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
fun GetBox(){

    var mensajeTexto by remember { mutableStateOf("climatizacion sostenible") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.fondo),
            contentDescription = "Imagen de fondo",
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)

        )
        Text(
            text = mensajeTexto,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,

        )

    }
}

@Composable
fun GetColumn(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp)
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(

        ) {
            Text(text = "columna 1")
            Spacer(modifier = Modifier.width(32.dp))
            Text(text = "columna 2")
        }
        Text(
            text = "texto 1"
        )
        Text(
            text = "texto2"
        )
    }
}

@Composable
fun ComposeQuadrantApp() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                backgroundColor = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                backgroundColor = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            ComposableInfoCard(
                title = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                backgroundColor = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            ComposableInfoCard(
                title = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
                backgroundColor = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ComposableInfoCard(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}


@Composable
fun FourQuadrantsScreen() {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        // Parte superior
        Row(
            modifier = Modifier.weight(1f)
        ) {

            // Cuadrante 1
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFE57373)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "1",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Cuadrante 2
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF64B5F6)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "2",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        // Parte inferior
        Row(
            modifier = Modifier.weight(1f)
        ) {

            // Cuadrante 3
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFF81C784)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            // Cuadrante 4
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color(0xFFFFB74D)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "4",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun CuadranteCompose(modifier: Modifier = Modifier) {
    Column(
        Modifier.fillMaxWidth()
    ) {
        Row(
            Modifier.weight(1f)
        ) {
            CuadranteCard(modifier = Modifier.weight(1f))
            CuadranteCard(modifier = Modifier.weight(1f))
        }

        Row(
            Modifier.weight(1f)
        ) {
            CuadranteCard(modifier = Modifier.weight(1f))
            CuadranteCard(modifier = Modifier.weight(1f))
        }

    }
}


@Composable
fun CuadranteCard(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.purple_200))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Text(
            text = "TText composable",
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Displays text and follows the recommended Material Design guidelines.",
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )

    }
}

@Composable
fun EndTask() {
    val taskImagen = painterResource(R.drawable.ic_task_completed)
    val taskTitle = stringResource(R.string.task_title_text)
    val taskSubtitle = stringResource(R.string.task_subtitle_text)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = taskImagen,
            contentDescription = "logo de task",
            modifier = Modifier
                .size(200.dp),
            //contentScale = ContentScale.Crop
        )

        Text(
            text = taskTitle,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold
        )

        Text(
            text = taskSubtitle,
            fontSize = 16.sp
        )
    }
}

@Composable
fun ComposeArticulo() {
    val title = stringResource(R.string.article_title_text)
    val paragraph1 = stringResource(R.string.article_paragraph1_text)
    val paragraph2 = stringResource(R.string.article_paragraph2_text)
    val logoArticle = painterResource(R.drawable.bg_compose_background)


    Column(
        // modifier = Modifier.padding(vertical = 64.dp)
    ) {
        Image(
            painter = logoArticle,
            contentDescription = null
        )

        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )

        Text(
            text = paragraph1,
            modifier = Modifier.padding(start = 15.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )

        Text(
            text = paragraph2,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
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