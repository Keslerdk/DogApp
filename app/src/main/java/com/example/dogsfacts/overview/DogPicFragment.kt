package com.example.dogsfacts.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dogsfacts.R

class DogPicFragment : Fragment(R.layout.fragment_dog_pic) {

    val viewModel : DogPicViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.getDogPictures()
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}