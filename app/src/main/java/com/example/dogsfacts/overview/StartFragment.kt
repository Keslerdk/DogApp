package com.example.dogsfacts.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.dogsfacts.R
import com.example.dogsfacts.databinding.FragmentStartBinding

class StartFragment : Fragment(R.layout.fragment_start) {

    var binding: FragmentStartBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.startFragment = this
    }

    fun navigateToDogFacts() {
        findNavController().navigate(R.id.action_startFragment_to_dogFactsFragment)
    }

    fun navigateToDogPic() {
        findNavController().navigate(R.id.action_startFragment_to_dogPicFragment)
    }
}