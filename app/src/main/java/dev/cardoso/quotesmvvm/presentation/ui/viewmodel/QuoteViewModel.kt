package dev.cardoso.quotesmvvm.presentation.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.cardoso.quotesmvvm.data.model.QuoteModel
import dev.cardoso.quotesmvvm.domain.GetQuotesUseCase
import dev.cardoso.quotesmvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(private val getQuotesUseCase:GetQuotesUseCase,
                                 private val getRandomQuoteUseCase:GetRandomQuoteUseCase): ViewModel() {

    private val _quoteModel = MutableStateFlow(QuoteModel("",""))
    val quoteModel: StateFlow<QuoteModel> = _quoteModel

    val _stateLoading = MutableStateFlow<Boolean>(false)
    val isLoading : StateFlow<Boolean> = _stateLoading


    fun randomQuote() {
        viewModelScope.launch {
            _stateLoading.value=true
            val quote = getRandomQuoteUseCase()
            if(quote!=null){
                _quoteModel.value = quote
            }
            _stateLoading.value=false
        }
    }
    fun onCreate() {
        viewModelScope.launch {
            _stateLoading.value=true
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                _quoteModel.value = result[0]
            }
            _stateLoading.value=false
        }
    }

}