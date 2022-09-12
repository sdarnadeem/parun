package dev.nasyxnadeem.parun.repository

import dev.nasyxnadeem.parun.data.DataOrException
import dev.nasyxnadeem.parun.model.SigninData
import dev.nasyxnadeem.parun.model.SigninResponse
import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import dev.nasyxnadeem.parun.network.BackendAPI
import retrofit2.Response
import javax.inject.Inject

class BackendRepo  @Inject constructor(private val api: BackendAPI){

    suspend fun signup(signupData: SignupData) : Response<SignupResponse> {
        return  api.signupUser(signupData)
    }

    suspend fun signin(signinData: SigninData) : Response<SigninResponse> {
        return api.signinUser(signinData)
    }

}