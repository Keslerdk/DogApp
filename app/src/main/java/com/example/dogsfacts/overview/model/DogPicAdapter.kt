package com.example.dogsfacts.overview.model

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogsfacts.databinding.DogPicItemBinding

class DogPicAdapter() : ListAdapter<String, DogPicAdapter.DogPicViewHolder>(DiffCallBack) {

    class DogPicViewHolder(private val binding: DogPicItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: String) {
            binding.photo = image
        }
    }

    object DiffCallBack : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem==newItem

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogPicViewHolder {
        return DogPicViewHolder(
            DogPicItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DogPicViewHolder, position: Int) {
        val dogPic = getItem(position)

        holder.bind(dogPic)
    }

}