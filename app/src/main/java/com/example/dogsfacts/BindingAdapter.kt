package com.example.dogsfacts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsfacts.network.DogFact
import com.example.dogsfacts.overview.DogFactsAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<DogFact>?) {
    val adapter = recyclerView.adapter as DogFactsAdapter
    adapter.submitList(data)
}