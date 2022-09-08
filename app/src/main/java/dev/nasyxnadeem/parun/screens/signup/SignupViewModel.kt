package dev.nasyxnadeem.parun.screens.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.nasyxnadeem.parun.data.DataOrException
import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import dev.nasyxnadeem.parun.repository.BackendRepo
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignupViewModel @Inject constructor(
    private val repo: BackendRepo
) : ViewModel() {

    val data: MutableState<DataOrException<SignupResponse, Boolean, Exception>> = mutableStateOf(
        DataOrException(SignupResponse(), false, Exception())
    )
//    var data: MutableLiveData<DataOrException<SignupResponse, Boolean, Exception>> = MutableLiveData()

//    val data: MutableState<Resource> = mutableStateOf(Resource.Success(data = SignupResponse()))



    fun signupUser(signupData: SignupData) {
        viewModelScope.launch {
            println("LOADING 1 "+data.value.loading)
            data.value.loading = true
            println("LOADING 2 "+data.value.loading)

            data.value.data = repo.signup(signupData).data
            println("LOADING 3 "+data.value.loading)
            println("VIEW MODEL DATA " + data.value.data)

            data.value.loading = false
            println("LOADING 4 "+data.value.loading)


        }
    }
}