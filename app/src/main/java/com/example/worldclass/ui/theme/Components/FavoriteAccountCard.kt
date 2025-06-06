package com.example.worldclass.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.worldclass.R

@Composable
fun FavoriteAccountCard(
    id: Int,
    name: String,
    username: String,
    password: String,
    imageURL: String,
    description: String,
    onDeleteClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.background),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = imageURL,
                contentDescription = "Account logo",
                contentScale = ContentScale.Fit,
                error = painterResource(R.drawable.jjk2),
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)

            )
            Text(
                text = name,
                modifier = Modifier.weight(1f),
                fontWeight = FontWeight.Bold
            )

            IconButton(onClick = {onDeleteClick()}) {
                Icon(imageVector = Icons.Filled.Delete, contentDescription = "Delete Account")
            }

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Username",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = username,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Password",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = password,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

        }
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Description:",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = description,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

        }
    }
}