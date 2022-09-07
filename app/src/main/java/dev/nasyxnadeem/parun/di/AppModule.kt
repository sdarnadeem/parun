package dev.nasyxnadeem.parun.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.nasyxnadeem.parun.network.BackendAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideBookApi(): BackendAPI {
        return Retrofit.Builder()
            .baseUrl("https://prikshaprep.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BackendAPI::class.java)
    }
}