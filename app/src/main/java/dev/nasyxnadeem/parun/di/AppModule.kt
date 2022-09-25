package dev.nasyxnadeem.parun.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.nasyxnadeem.parun.dao.UserDatabase
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

    @Singleton
    @Provides
    fun provideUserDoa(userDatabase : UserDatabase) : userDatabase.userDao()

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context)


}