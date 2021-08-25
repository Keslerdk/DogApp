package com.example.dogsfacts.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dogsfacts.R
import com.example.dogsfacts.databinding.FragmentDogPicBinding
import com.example.dogsfacts.overview.model.DogPicAdapter
import com.example.dogsfacts.overview.model.DogPicViewModel

class DogPicFragment : Fragment(R.layout.fragment_dog_pic) {

    val viewModel : DogPicViewModel by viewModels()
    var _binding: FragmentDogPicBinding? = null
    val binding get()  = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragmnet = FragmentDogPicBinding.inflate(inflater, container, false)
        _binding = fragmnet
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.dogPicRecyclerView.adapter = DogPicAdapter()

        return fragmnet.root
    }
}