package dev.nasyxnadeem.parun.screens.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
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
            data.value?.loading = true
            data.value?.data = repo.signup(signupData).data
            data.value?.loading = false

        }
    }
}