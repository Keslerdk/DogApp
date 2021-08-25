package com.example.dogsfacts

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsfacts.network.DogFact
import com.example.dogsfacts.overview.model.DogFactsAdapter
import com.example.dogsfacts.overview.model.DogPicAdapter

@BindingAdapter("factListData")
fun bindRecyclerView(recyclerView: RecyclerView,
                     data: List<DogFact>?) {
    val adapter = recyclerView.adapter as DogFactsAdapter
    adapter.submitList(data)
}

@BindingAdapter("picListData")
fun bindPicRecyclerView(recyclerView: RecyclerView, data: List<String>?) {
    val adapter = recyclerView.adapter as DogPicAdapter
    adapter.submitList(data)
}