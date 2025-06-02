package com.example.worldclass.ui.theme.screens
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController


@Composable
fun MainMenuScreen(navController:NavHostController) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "main menu", fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold
        )
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
        Button(
            onClick = { navController.navigate("LoginScreen") }

        ) {
            Text("Go to Login Screen")
        }
        Button(
            onClick = { navController.navigate("accountsScreen") }

        ) {
            Text("Go to Accounts screen")
        }
        Button(
            onClick = { navController.navigate("Manage_Account_Screen") }

        ) {
            Text("Go to Manage account screen")
        }
        Button(
            onClick = { navController.navigate("favorite_account_screen") }

        ) {
            Text("Go to favotite account screen")
        }
        Button(
            onClick = { navController.navigate("apiPush")}

        ) {
            Text("Go to Push notifications Api ")
        }
        Button(
            onClick = { navController.navigate("camera-api")}

        ) {
            Text("Go to camera screen ")
        }
        Button(
            onClick = { navController.navigate("ContactsCalendar")}

        ) {
            Text("Go to Contacts and calendar Api ")
        }
    }

}
