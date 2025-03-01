package com.example.worldclass.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.worldclass.R
import com.example.worldclass.ui.theme.WorldclassTheme

@Composable

fun TestScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxSize()
    ) {
        // Texto que indica la pantalla actual
        Text("Test Screen")

        // Botón para volver al menú principal
        Button(
            onClick = { navController.navigate("Main_Menu") }
        ) {
            Text("Return to Main Menu")
        }

        // Otro botón que navega a la misma pantalla
        Button(
            onClick = { navController.navigate("TextScreen") }
        ) {
            Text("Go to Test Screen")
        }
// Diferentes estructuras con texto reutilizable
        Column {
            Column {
                TextComposable()
                TextComposable()
                TextComposable()
            }
            Row {
                TextComposable()
                TextComposable()
                TextComposable()
            }
            Column {
                ModifierExample2()
            }
        }

        Column {
            ModifierExample4()
            CustomText()
            Picture()
        }
    }
}
// Función composable de texto reutilizable con un valor predeterminado
@Preview(showBackground = true)
@Composable
fun TextComposable(name: String = "Empty") {
    Text("Hello World")
    Text(name)
}

// Ejemplo de uso de modificadores con padding
@Preview(showBackground = true)
@Composable
fun ModifierExample1() {
    Column(
        modifier = Modifier
            .padding(50.dp, 30.dp, 20.dp, 10.dp)
    ) {
        Text("Hello World")
    }
}

@Preview(showBackground = true)
@Composable
fun ModifierExample2() {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
            .clickable(onClick = { clickAction() })
    ) {
        Text("Hello World")
    }
}

// Acción que se ejecuta al hacer clic
fun clickAction() {
    println("Column Clicked")
}
// Ejemplo de modificador con altura, fondo y borde
@Preview(showBackground = true)
@Composable
fun ModifierExample3() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
            .background(Color.Yellow)
            .border(width = 2.dp, color = Color.Green)
            .width(200.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        TextComposable("1")
        TextComposable("2")
        TextComposable("3")
        TextComposable("4")
        TextComposable("5")
        TextComposable("6")
    }
}


@Preview(showBackground = true)
@Composable
fun ModifierExample4() {
    Box(
        modifier = Modifier
            .background(Color.Cyan)
            .padding(10.dp)
            .height(300.dp)
            .width(300.dp)
    ) {
        Text("1", Modifier.align(Alignment.TopStart))
        Text("2", Modifier.align(Alignment.TopCenter))
        Text("3", Modifier.align(Alignment.TopEnd))
        Text("4", Modifier.align(Alignment.CenterStart))
        Text("5", Modifier.align(Alignment.Center))
        Text("6", Modifier.align(Alignment.CenterEnd))
        Text("7", Modifier.align(Alignment.BottomStart))
        Text("8", Modifier.align(Alignment.BottomCenter))
        Text("9", Modifier.align(Alignment.BottomEnd))
    }
}
// Ejemplo de texto con color y gradientes
@Preview(showBackground = true)
@Composable
fun CustomText() {
    Column {
        Text(
            stringResource(R.string.single_text),
            color = colorResource(R.color.teal_700),
            fontSize = 20.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )

        // Aplicación de un gradiente de colores al texto
        val gradientColors = listOf(Color.Blue, Color.Green, Color.Cyan, colorResource(R.color.purple_200))
        Text(
            stringResource(R.string.single_text),
            style = TextStyle(brush = Brush.linearGradient(colors = gradientColors))
        )
    }
}
// Composable que muestra una imagen con fondo gris
@Preview(showBackground = true)
@Composable
fun Picture() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .height(300.dp)
    ) {
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.jjk2), // Carga imagen desde los recursos drawables
            contentDescription = "Imagen JJK2"
        )
    }
}