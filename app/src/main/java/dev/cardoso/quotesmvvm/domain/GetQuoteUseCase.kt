package dev.cardoso.quotesmvvm.domain

import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor() {

    operator fun invoke(): QuoteModel?{
        val quotes = QuoteProvider.quotes
        val quoteDefault=QuoteModel("Caminante no hay camino, se hace camino al andar",
            "Antonio Machado")
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return quoteDefault
    }
}