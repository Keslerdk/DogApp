package com.example.dogsfacts

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.dogsfacts.network.DogFact
import com.example.dogsfacts.overview.model.DogFactsAdapter
import com.example.dogsfacts.overview.model.DogFactsApiStatus
import com.example.dogsfacts.overview.model.DogPicAdapter
import com.example.dogsfacts.overview.model.DogPicApiStatus

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

@BindingAdapter("imageUrl")
fun bindImageView(imageView: ImageView, imgUrl: String? ) {
    imgUrl?.let{
        val imgUri = it.toUri().buildUpon().scheme("https").build()
        imageView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }
    }
}

@BindingAdapter("dogFactsApiStatus")
fun bindFactsStatus(statusImageView: ImageView,
               status: DogFactsApiStatus?) {

    when (status) {
        DogFactsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DogFactsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_error_connection)
        }
        DogFactsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

@BindingAdapter("dogPicApiStatus")
fun bindPicStatus(statusImageView: ImageView, status: DogPicApiStatus?) {
    when (status) {
        DogPicApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        DogPicApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_error_connection)
        }
        DogPicApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}

