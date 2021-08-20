package com.example.dogsfacts.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsfacts.network.DogFact
import com.example.dogsfacts.network.DogFactsApi
import kotlinx.coroutines.launch

class DogFactsViewModel : ViewModel() {

    private var _text = MutableLiveData<List<DogFact>>()
    val text: LiveData<List<DogFact>> = _text

    init {
        getDogFacts()
    }


    fun getDogFacts() {
        viewModelScope.launch {
            try {
                val listResult = DogFactsApi.retrofitService.getFacts()
                Log.d(TAG, "getDogFacts: ${listResult}")
                _text.value = listResult
            } catch (e: Exception) {
                Log.d(TAG, "getDogFacts: ${e}")
            }
        }
    }

    companion object {
        private const val TAG = "DogFactsViewModel"
    }
}