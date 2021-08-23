package com.example.dogsfacts.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsfacts.network.DogFact
import com.example.dogsfacts.network.DogFactsApi
import kotlinx.coroutines.launch

enum class DogFactsApiStatus { LOADING, ERROR, DONE }

class DogFactsViewModel : ViewModel() {

    private var _text = MutableLiveData<List<DogFact>>()
    val text: LiveData<List<DogFact>> = _text

    private var _status = MutableLiveData<DogFactsApiStatus>()
    val status: LiveData<DogFactsApiStatus> = _status

    init {
        getDogFacts()
    }


    fun getDogFacts() {
        viewModelScope.launch {
            _status.value = DogFactsApiStatus.LOADING
            try {
                val listResult = DogFactsApi.retrofitService.getFacts()
                Log.d(TAG, "getDogFacts: ${listResult}")
                _text.value = listResult
                _status.value = DogFactsApiStatus.DONE
            } catch (e: Exception) {
                Log.d(TAG, "getDogFacts: ${e}")
                _status.value = DogFactsApiStatus.ERROR
            }

        }
    }

    companion object {
        private const val TAG = "DogFactsViewModel"
    }
}