package com.example.worldclass.ui.theme.screens

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.worldclass.Data.Model.UserModel
import com.example.worldclass.Data.ViewModel.UserViewModel



@Composable
fun LoginScreen(navHostController: NavHostController){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll((rememberScrollState())),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ){
        LoginForm(navController = navHostController)
    }
}

@Composable
fun LoginForm(viewModel: UserViewModel = viewModel (), navController: NavHostController){
    val context= LocalContext.current
    Card(
        modifier = Modifier. padding(40.dp,0.dp)

    ) {
        Column (
            modifier = Modifier.padding(20.dp)
        ){
            var user by remember { mutableStateOf("") }
            var password by remember{ mutableStateOf("")}

            AsyncImage(
                model = "https://logosmarcas.net/wp-content/uploads/2020/12/GitHub-Simbolo.png",
                contentDescription = "Git Hub Logo",
                contentScale = ContentScale.Fit

            )
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = user,
                maxLines = 1,
                onValueChange = { user = it },
                label = { Text("User")}

            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                maxLines = 1,
                onValueChange = { password = it },
                label = { Text("Password")}

            )
            FilledTonalButton(
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.secondary
                ),
                modifier = Modifier.fillMaxWidth().padding(10.dp,10.dp),
                shape = CutCornerShape(4.dp),
                onClick = { TryLogin(user,password,context, viewModel, navController ) }
            ) {
                Text("LOG IN")
            }
            OutlinedButton (
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.primary
                ),
                modifier = Modifier.fillMaxWidth().padding(0.dp,10.dp),
                shape = CutCornerShape(4.dp),
                onClick = {}
            ) {
                Text("CREATE ACCOUNT")
            }

        }
    }

}
fun TryLogin(
    user:String,
    password:String,
    context: Context,
    viewModel: UserViewModel,
    navController: NavHostController
) {
    if (user == "" || password == "") {
        Toast.makeText(
            context,
            "User or Password cannot be empty",
            Toast.LENGTH_SHORT
        ).show()
    } else {
        val user_model = UserModel(0, "", user, password)
        viewModel.loginAPI(user_model) { jsonResponse ->
            val loginStatus = jsonResponse?.get("login")?.asString
            Log.d("debug", "LOGIN STATUS:$loginStatus")

            if (loginStatus == "success") {
                navController.navigate("Home_Screen") {

                    popUpTo(navController.graph.startDestinationId) {
                        inclusive = true
                    }
                }
            } else {

                Toast.makeText(
                    context,
                    "Invalid credentials. Please try again",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}