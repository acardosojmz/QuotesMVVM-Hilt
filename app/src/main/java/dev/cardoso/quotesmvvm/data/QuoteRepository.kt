package dev.cardoso.quotesmvvm.data

import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.data.model.QuoteProvider
import dev.cardoso.quotesmvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val api: QuoteService ){
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}