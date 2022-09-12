package dev.nasyxnadeem.parun.network

import dev.nasyxnadeem.parun.model.SigninData
import dev.nasyxnadeem.parun.model.SigninResponse
import dev.nasyxnadeem.parun.model.SignupData
import dev.nasyxnadeem.parun.model.SignupResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import javax.inject.Singleton


@Singleton
interface BackendAPI {

    @POST("auth/signup")
    suspend fun signupUser(@Body signupData: SignupData): Response<SignupResponse>

    @POST("auth/signin")
    suspend fun signinUser(@Body signinData: SigninData): Response<SigninResponse>

}