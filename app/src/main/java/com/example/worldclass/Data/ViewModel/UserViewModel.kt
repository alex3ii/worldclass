package com.example.worldclass.Data.ViewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.worldclass.Data.Model.AccountModel
import com.example.worldclass.Data.Model.UserModel
import com.example.worldclass.Data.Network.RetrofitClient
import com.google.gson.JsonObject
import kotlinx.coroutines.launch
import retrofit2.Response

class UserViewModel:ViewModel() {
    val api = RetrofitClient.api
    fun loginAPI(user_model: UserModel, onResult:(JsonObject?) -> Unit){
        viewModelScope.launch {
            try{
                val response = api.login(user_model)
                if (response.isSuccessful){
                    val jsonResponse = response.body()
                    Log.d("debug",response.body().toString())
                    onResult(jsonResponse)
                }
                else{
                    Log.d("debug","ERROR:${response.body()}")
                    onResult(null)
                }
            }catch (exception:Exception){
                Log.d("debug","API CALL FAILED:$exception")
                onResult(null)

            }

        }
    }
   // fun getAccount(id:Int,onResult:(Response<AccountModel> )->unit1
}
