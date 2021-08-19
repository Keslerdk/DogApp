package com.example.dogsfacts.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.dogsfacts.R
import com.example.dogsfacts.databinding.FragmentDogFactsBinding

class DogFactsFragment : Fragment(R.layout.fragment_dog_facts) {

    private val viewModel: DogFactsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragment = FragmentDogFactsBinding.inflate(inflater, container, false)
        val binding: FragmentDogFactsBinding = fragment
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}