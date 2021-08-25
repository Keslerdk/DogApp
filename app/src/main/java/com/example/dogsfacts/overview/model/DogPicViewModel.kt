package com.example.dogsfacts.overview.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogsfacts.network.DogPicture
import com.example.dogsfacts.network.DogPictureApi
import kotlinx.coroutines.launch

enum class DogPicApiStatus {LOADING, DONE, ERROR}

class DogPicViewModel: ViewModel() {

    private  var _data = MutableLiveData<DogPicture>()
    val data: LiveData<DogPicture> = _data

    private var _status = MutableLiveData<DogPicApiStatus>()
    val status : LiveData<DogPicApiStatus> = _status

    init {
        getDogPictures()

    }

    fun getDogPictures() {

        _status.value = DogPicApiStatus.LOADING

        viewModelScope.launch {
            try {
                _data.value = DogPictureApi.retrofitService.getDogPicture()
                _status.value = DogPicApiStatus.DONE
            } catch (e: Exception) {
                Log.d(TAG, "getDogPictures: smth gone wrong")
                _status.value = DogPicApiStatus.ERROR
            }

        }
    }

    companion object {
        private const val TAG = "DogPicViewModel"
    }
}