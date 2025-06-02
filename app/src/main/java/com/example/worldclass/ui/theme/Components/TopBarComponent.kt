package com.example.worldclass.ui.theme.Components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarComponent(title: String, navController: NavController, location:String ){
    TopAppBar(
        title = {Text(title)},
        actions = {
            if (location == "accountsScreen") {
                IconButton(onClick = { navController.navigate("manage_account_screen") }) {
                    Icon(imageVector = Icons.Filled.Add, contentDescription = "Add")
                }
                IconButton(onClick = { navController.navigate("favorite_account_screen") }) {
                    Icon(imageVector = Icons.Filled.Star, contentDescription = "Favorites")
                }
            }
        }

    )
}