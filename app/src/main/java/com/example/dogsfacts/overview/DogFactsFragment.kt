package com.example.dogsfacts.overview

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.dogsfacts.R
import com.example.dogsfacts.databinding.FragmentDogFactsBinding

class DogFactsFragment : Fragment() {

    private val viewModel: DogFactsViewModel by viewModels()
    private lateinit var binding: FragmentDogFactsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val fragment = FragmentDogFactsBinding.inflate(inflater, container, false)
//        val binding: FragmentDogFactsBinding = fragment
        binding = fragment

        binding.apply {
            lifecycleOwner = this@DogFactsFragment
            dogFactsRecyclerView.adapter = DogFactsAdapter()
        }

        binding.viewModel = viewModel
        return fragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.swipeUpToRefresh.setColorSchemeColors(this.resources.getColor(R.color.orange))

        binding.swipeUpToRefresh.setOnRefreshListener {

            viewModel.getDogFacts()

            viewModel.status.observe(viewLifecycleOwner, {
                when (it) {
                    DogFactsApiStatus.DONE -> {
                        binding.swipeUpToRefresh.isRefreshing = false
                        Log.d("u", "onViewCreated: refreshed")
                    }
                    else -> print("adv")
                }
            })

        }
    }
}