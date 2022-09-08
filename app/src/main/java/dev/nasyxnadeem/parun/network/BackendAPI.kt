package dev.nasyxnadeem.parun.network

import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton


@Singleton
interface BackendAPI {

    @POST("auth/signup")
    suspend fun signupUser(@Body signupData: SignupData): SignupResponse

}