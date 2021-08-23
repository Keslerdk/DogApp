package com.example.dogsfacts.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsfacts.network.DogPicture
import com.example.dogsfacts.network.DogPictureApi
import kotlinx.coroutines.launch

class DogPicViewModel: ViewModel() {

    private  var _data = MutableLiveData<DogPicture>()
    val data: LiveData<DogPicture> = _data

    init {
        getDogPictures()

    }

    fun getDogPictures() {
        Log.d(TAG, "initialized!")
        viewModelScope.launch {
            try {
                val listResult = DogPictureApi.retrofitService.getDogPicture()
                Log.d(Companion.TAG, "getDogPictures: ${listResult}")
            } catch (e: Exception) {
                Log.d(TAG, "getDogPictures: smth gone wrong")
            }

        }
    }

    companion object {
        private const val TAG = "DogPicViewModel"
    }
}