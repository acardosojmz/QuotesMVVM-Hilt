package dev.cardoso.quotesmvvm.data.network

import dev.cardoso.quotesmvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/quotes.php")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>
}