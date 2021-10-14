package dev.cardoso.quotesmvvm.data.model

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class QuoteProvider  @Inject constructor() {
    companion object {
         var quotes:List<QuoteModel> = emptyList()
    }
}