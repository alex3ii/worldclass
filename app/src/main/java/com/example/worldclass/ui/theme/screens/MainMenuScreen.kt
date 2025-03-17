package com.example.worldclass.ui.theme.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun MainMenuScreen(navController:NavHostController) {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Text("main menu")
        Button(
            onClick = { navController.navigate("home_screen") }
        )
        { Text("go to home screen") }
        Button(
            onClick = { navController.navigate("TextScreen") }
        )
        { Text("go to test screen") }
        Button(
            onClick = { navController.navigate("components_screen") }
        )
        { Text("go to components screen") }
        Button(
            onClick = { navController.navigate("CinepolisApp") }
        )
        { Text("go to cinepolis screen") }

    }

}
