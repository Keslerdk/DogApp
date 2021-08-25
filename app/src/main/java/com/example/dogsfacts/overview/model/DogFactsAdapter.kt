package com.example.dogsfacts.overview.model

import android.content.ActivityNotFoundException
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsfacts.R
import com.example.dogsfacts.databinding.DogFactsItemBinding
import com.example.dogsfacts.network.DogFact

class DogFactsAdapter():
    ListAdapter<DogFact, DogFactsAdapter.DogFactsViewHolder>(DiffCallback) {


    class DogFactsViewHolder(private var binding: DogFactsItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        val shareBtn = binding.share
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
        val context = holder.shareBtn.context
        val dogFact = getItem(position)
        Log.d(TAG, "onBindViewHolder: ${position}")
        holder.bind(dogFact)

        holder.shareBtn.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, context.getString(R.string.send_email,
                    dogFact.fact))
                type = "text/plain"
            }
            try {

                context.startActivity(sendIntent)
            } catch (e: ActivityNotFoundException) {
                // Define what your app should do if no activity can handle the intent.
            }
        }

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