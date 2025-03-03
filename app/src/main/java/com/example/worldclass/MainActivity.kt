package com.example.worldclass
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import com.example.worldclass.ui.theme.WorldclassTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
         CinepolisApp()
        }
    }
}

@Composable
fun CinepolisApp() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 18.dp)
                .background(Color.Blue),

            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Cartelera",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color=Color.White
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical =0.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.estrenos),
                    contentDescription = "estrenos",
                    modifier = Modifier.size(350.dp).height(0.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    "",
                    fontSize = 0.sp,
                    textAlign = TextAlign.Center
                )
            }



        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {

                    println("Espacio Aguascalientes button clicked!")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Cyan)
            ) {
                Text(
                    "  Espacio Aguascalientes  ",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.capitan_america),
                    contentDescription = "capitan america",
                    modifier = Modifier.size(180.dp).height(30.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    " ",
                    fontSize = 0.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.peliculas_2),
                    contentDescription = "capitan america",
                    modifier = Modifier.size(180.dp).height(30.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    " ",
                    fontSize = 0.sp,
                    textAlign = TextAlign.Center
                )
            }
        }


        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 22.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pelicula_1_bottom),
                    contentDescription = "capitan america",
                    modifier = Modifier.size(150.dp).height(30.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    " ",
                    fontSize = 0.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pelicula_2_bottom),
                    contentDescription = "capitan america",
                    modifier = Modifier.size(150.dp).height(30.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    " ",
                    fontSize = 0.sp,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pelicula_3_bottom),
                    contentDescription = "capitan america",
                    modifier = Modifier.size(150.dp).height(30.dp),
                    contentScale = ContentScale.Fit

                )
                Text(
                    " ",
                    fontSize = 0.sp,
                    textAlign = TextAlign.Center
                )
            }
        }

        BottomAppBar(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            contentPadding = PaddingValues(0.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Home, contentDescription = "Películas")
                }
                Text("Películas")
                Text("Alimentos")
                Text("Club")
                Text("Cines")
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.AccountCircle, contentDescription = "Perfil")
                }
                Text("Perfil")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CinepolisApp()
}