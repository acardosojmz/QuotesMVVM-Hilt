package dev.cardoso.quotesmvvm.domain

import dev.cardoso.quotesmvvm.data.QuoteRepository
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuotesUseCase  @Inject constructor( private val repository: QuoteRepository){
     suspend operator fun invoke():List<QuoteModel>? = repository.getAllQuotes()

}
