package dev.nasyxnadeem.parun.screens.signin

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nasyxnadeem.parun.SessionManager
import dev.nasyxnadeem.parun.Token
import dev.nasyxnadeem.parun.model.SigninData
import dev.nasyxnadeem.parun.model.SigninResponse
import dev.nasyxnadeem.parun.repository.BackendRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SigninViewModel @Inject constructor(private val repo: BackendRepo): ViewModel() {


    val loading: MutableState<Boolean> = mutableStateOf(false)



    val data: MutableState<SigninResponse?> = mutableStateOf(null)

    val e: MutableState<Exception?> = mutableStateOf(null)

     fun signinUser(signinData: SigninData) {
        viewModelScope.launch {
            try {
                loading.value = true
                val response = repo.signin(signinData)

                if (response.code() == 401) throw Exception("Invalid Email or Password")
                data.value = response.body()
//
//                sessionManager.setToken(response.body()?.token.toString())
//
//                println(token)
                println(response)
            }catch (ex: Exception) {
                e.value  = ex
            } finally {
                loading.value = false
                println(e.value)

            }
        }
    }


}

