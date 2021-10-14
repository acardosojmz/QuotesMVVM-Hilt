package dev.cardoso.quotesmvvm.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.cardoso.quotesmvvm.data.network.QuoteApiClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.21")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideQuoteApiClient(retrofit: Retrofit): QuoteApiClient {
        return retrofit.create(QuoteApiClient::class.java)
    }
}