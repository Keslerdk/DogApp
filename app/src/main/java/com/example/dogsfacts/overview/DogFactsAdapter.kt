package com.example.dogsfacts.overview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsfacts.databinding.DogFactsItemBinding
import com.example.dogsfacts.network.DogFact

class DogFactsAdapter():
    ListAdapter<DogFact, DogFactsAdapter.DogFactsViewHolder>(DiffCallback) {

    init {
//        Log.d(Companion.TAG, "${dataSet} ")
    }

    class DogFactsViewHolder(private var binding: DogFactsItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(dogFact: DogFact) {
            binding.fact.text = dogFact.fact
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogFactsViewHolder {
        return DogFactsViewHolder(DogFactsItemBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: DogFactsViewHolder, position: Int) {
        val dogFact = getItem(position)
        Log.d(TAG, "onBindViewHolder: ${position}")
        holder.bind(dogFact)
    }


    companion object {
        private const val TAG = "DogFactsAdapter"
    }

    object DiffCallback: DiffUtil.ItemCallback<DogFact> (){
        override fun areItemsTheSame(oldItem: DogFact, newItem: DogFact): Boolean {
            return oldItem.fact == newItem.fact
        }

        override fun areContentsTheSame(oldItem: DogFact, newItem: DogFact): Boolean {
            return oldItem.fact == newItem.fact
        }

    }
}