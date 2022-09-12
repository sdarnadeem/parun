package dev.nasyxnadeem.parun.screens.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import dev.nasyxnadeem.parun.repository.BackendRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repo: BackendRepo
) : ViewModel() {



    val loading = mutableStateOf(false)
    val data: MutableState<SignupResponse?> = mutableStateOf(SignupResponse())
    val exception = mutableStateOf(Exception())

    fun signupUser(signupData: SignupData) {
        viewModelScope.launch {

            try {
                loading.value = true
                val response = repo.signup(signupData)
                data.value = response.body()
                println("RESPONSE111 ${response.message()}")
                println("RESPONSE112 ${response.raw()}")
                println("RESPONSE113 ${response.body()}")
                println("RESPONSE114 ${response.code()}")
                println("RESPONSE115 ${response.errorBody()}")
                println("RESPONSE116 ${response.headers()}")
                if (response.code() == 409) throw Exception("Email Id or Phone Number already Exists")
                exception.value = Exception()
            } catch (e: Exception) {
                exception.value = e
                println("EXCEPTION ${e.message}")
            } finally {
                loading.value = false
            }


        }
    }
}