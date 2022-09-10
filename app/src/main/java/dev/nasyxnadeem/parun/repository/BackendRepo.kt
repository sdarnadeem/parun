package dev.nasyxnadeem.parun.repository

import dev.nasyxnadeem.parun.data.DataOrException
import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import dev.nasyxnadeem.parun.network.BackendAPI
import javax.inject.Inject

class BackendRepo  @Inject constructor(private val api: BackendAPI){

    suspend fun signup(signupData: SignupData) : DataOrException<SignupResponse, Boolean,Exception> {
        return try {
            val response = api.signupUser(signupData)
            println("RESPONSE $response")

            DataOrException(response.body(), false, null)
        }catch (e: Exception) {
            DataOrException(null, false, e)
        }
    }

}