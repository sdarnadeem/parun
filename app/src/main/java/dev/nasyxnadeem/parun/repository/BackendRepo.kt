package dev.nasyxnadeem.parun.repository

import dev.nasyxnadeem.parun.data.Resource
import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import dev.nasyxnadeem.parun.network.BackendAPI
import javax.inject.Inject

class BackendRepo  @Inject constructor(private val api: BackendAPI){

    suspend fun signup(signupData: SignupData) : Resource<SignupResponse> {
        return try {
            Resource.Loading(data = true)

            val response = api.signupUser(signupData)
            Resource.Success(data = response)
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}