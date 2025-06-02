package com.example.worldclass.ui.theme.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.worldclass.Data.Model.AccountModel
import com.example.worldclass.Data.Model.toAccountEntity
import com.example.worldclass.Data.ViewModel.AccountViewModel
import com.example.worldclass.Data.database.AppDatabase
import com.example.worldclass.Data.database.DatabaseProvider
import com.example.worldclass.ui.theme.Components.AccountCardComponent
import com.example.worldclass.ui.theme.Components.TopBarComponent
import com.example.worldclass.ui.theme.Components.AccountDetailCardComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountsScreen(
    navController: NavHostController,
    viewModel: AccountViewModel = viewModel()
) {
    var accounts by remember { mutableStateOf<List<AccountModel>>(emptyList()) }
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false
    )
    var accountDetail by remember { mutableStateOf<AccountModel?>(null) }
    val db: AppDatabase = DatabaseProvider.getDatabase(LocalContext.current)
    val accountDao = db.accountDao()

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ){
        TopBarComponent(title = "Account Screen", navController, "accountsScreen")
        LaunchedEffect(Unit) {
            viewModel.getAccounts { response ->
                if (response.isSuccessful) {
                    accounts = response.body() ?: emptyList()
                } else {
                    Log.d("debug", "Failed to load accounts: ${response.code()}")
                }
            }
        }
        val listState = rememberLazyListState()
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            state = listState
        ) {
            items(accounts) { account ->
                AccountCardComponent(
                    account.id,
                    account.name,
                    account.username,
                    account.imageURL,

                    onButtonClick = {

                        viewModel.getAccount(account.id) { response ->
                            if (response.isSuccessful) {
                                accountDetail = response.body()
                            }
                        }
                        showBottomSheet = true

                    }
                )
            }
        }
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            modifier = Modifier
                .fillMaxHeight(),
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.background,
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
        ) {
            AccountDetailCardComponent(                accountDetail?.id ?: 0,
                accountDetail?.name ?: "",
                accountDetail?.username ?: "",
                accountDetail?.password ?: "",
                accountDetail?.imageURL ?: "",
                accountDetail?.description ?: "",
                navController = navController,
                onSaveClick = {
                    CoroutineScope(Dispatchers.IO).launch { //Para conectarnos con la base de datos interna y realizar operaciones
                        try {
                            accountDetail?.let { accountDao.insert(it.toAccountEntity()) }
                            Log.d("debug-db","account inserted successfully")
                        }catch (exception: Exception){
                            Log.d("debug-db","Error: $exception")
                        }
                    }
                },
                onDeleteClick = { id ->
                    viewModel.deleteAccount(id) { response ->
                        if (response != null) {
                            Log.d("debug-delete", "Cuenta con ID $id eliminada correctamente")
                            Toast.makeText(context, "Cuenta eliminada", Toast.LENGTH_SHORT).show()
                        } else {
                            Log.d("debug-delete", "Error al eliminar la cuenta con ID $id")
                            Toast.makeText(context, "Error al eliminar", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            )
        }
    }
}

