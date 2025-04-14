package com.example.worldclass

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.worldclass.Data.database.AppDatabase
import com.example.worldclass.Data.database.DatabaseProvider
import com.example.worldclass.ui.theme.screens.TryCreateAccount
import com.example.worldclass.ui.theme.WorldclassTheme
import com.example.worldclass.ui.theme.screens.AccountsScreen
import com.example.worldclass.ui.theme.screens.CinepolisApp
import com.example.worldclass.ui.theme.screens.ComponentsScreen
import com.example.worldclass.ui.theme.screens.FavoriteAccountsScreen
import com.example.worldclass.ui.theme.screens.HomeScreen
import com.example.worldclass.ui.theme.screens.LoginScreen
import com.example.worldclass.ui.theme.screens.MainMenuScreen
import com.example.worldclass.ui.theme.screens.ManageAccountScreen
import com.example.worldclass.ui.theme.screens.TestScreen



class MainActivity : ComponentActivity() {
    lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            database = DatabaseProvider.getDatabase(this)
            Log.d("debug-db", "DATABASE LOADED SUCCESSFULLY")
        } catch (exception: Exception) {
            Log.d("debug-db", "ERROR: $exception")
        }
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
            composable("components_screen") { ComponentsScreen(navController) }
            composable("CinepolisApp") { CinepolisApp(navController) }
            composable("LoginScreen") { LoginScreen(navController) }
            composable("accountsScreen") { AccountsScreen(navController) }
            composable("Manage_Account_Screen") { ManageAccountScreen(navController = navController) }
            composable(
                route = "Manage_Account_Screen/{id}",
                arguments = listOf(navArgument("id") { defaultValue = -1 })
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: -1
                ManageAccountScreen(
                    navController = navController,
                    accountId = id
                )
            }
            composable("favorite_account_screen") { FavoriteAccountsScreen(navController) }
        }
    }
}
