package com.example.worldclass.ui.theme.Components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.worldclass.R


@Composable
fun PostCardComponent (id:Int, title:String, text:String, image:Int){
    Card(
        modifier= Modifier
        .background(Color.LightGray)
        .fillMaxWidth()
        .padding(5.dp)
    ) {
        Text(
            text = "this is a title",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp)
        )
        Image(
            modifier= Modifier
                .fillMaxWidth()
                .height(200.dp),
            painter = painterResource(R.drawable.jjk2),
            contentDescription="jjk image",
            contentScale= ContentScale.Crop
        )
        Text(
            text = stringResource(R.string.insum_text),
            textAlign = TextAlign.Justify,
            lineHeight = 10.sp,
            modifier = Modifier.padding(10.dp)
        )
    }

}
@Composable
fun PostCardComopactComponent(id:Int, title:String, text:String, image:Int) {
    Card(
        modifier = Modifier
            .background(Color.Blue)  // Fondo azul para la tarjeta
            .fillMaxWidth()  // La tarjeta ocupa todo el ancho
            .padding(5.dp)  // Padding alrededor de la tarjeta
    ) {
        // Contenedor para la imagen con un Row (fila)
        Row() {
            Image(
                modifier = Modifier
                    .fillMaxWidth()  // Imagen ocupa todo el ancho
                    .width(80.dp)  // Imagen con ancho de 80dp
                    .height(100.dp),  // Imagen con altura de 100dp
                painter = painterResource(image),  // Reemplaza con tu recurso de imagen
                contentDescription = "imagen jjk",  // Descripción de la imagen
                contentScale = ContentScale.Inside  // Escala la imagen dentro de los límites
            )
        }
        // Contenedor de texto con un Column (columna)
        Column() {
            // Título dentro de la tarjeta
            Text(
                text = title,
                fontSize = 12.sp,  // Tamaño de fuente más pequeño
                fontWeight = FontWeight.Bold,  // Negrita
                modifier = Modifier
                    .padding(5.dp)  // Padding alrededor del texto
            )

            // Texto adicional dentro de la tarjeta
            Text(
                text = text,  // Texto obtenido de los recursos de cadena
                textAlign = TextAlign.Left,  // Alineación a la izquierda
                lineHeight = 14.sp,  // Altura de las líneas
                fontSize = 10.sp,  // Tamaño de fuente más pequeño
                modifier = Modifier.padding(10.dp)  // Padding dentro del texto
            )
        }
    }
}