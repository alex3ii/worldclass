package com.example.worldclass

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.worldclass.ui.theme.WorldclassTheme
import com.example.worldclass.ui.theme.screens.ComponentsScreen
import com.example.worldclass.ui.theme.screens.HomeScreen
import com.example.worldclass.ui.theme.screens.MainMenuScreen
import com.example.worldclass.ui.theme.screens.TestScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorldclassTheme {
                ComposeMultiScreenApp()

            }
        }
    }



    @Composable
    fun ComposeMultiScreenApp() {
        val navController = rememberNavController()
        SetupNavGraph(navController = navController)
    }

    @Composable
    fun SetupNavGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = "Main_Menu") {


            composable("Main_Menu") { MainMenuScreen(navController) }
            composable("Home_Screens") { HomeScreen(navController) }
            composable("TextScreen") { TestScreen(navController) }
            composable("components_screen"){ ComponentsScreen(navController) }

        }
    }
}





