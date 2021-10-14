package dev.cardoso.quotesmvvm.presentation.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import dev.cardoso.quotesmvvm.databinding.ActivityMainBinding
import dev.cardoso.quotesmvvm.presentation.ui.viewmodel.QuoteViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch



@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val quoteViewModel: QuoteViewModel by viewModels()


    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()
        observa()
        binding.viewContainer.setOnClickListener { quoteViewModel.randomQuote() }
    }


    private fun observa(){
        lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
        lifecycleScope.launch {
            quoteViewModel.isLoading.collect {
                Log.e("VISIBLE ", it.toString())
                binding.loading.isVisible = it
            }
        }
    }

}