package com.izmary.databinding.others.retrofitbasic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.facebook.shimmer.Shimmer
import com.facebook.shimmer.ShimmerDrawable
import com.izmary.databinding.others.retrofitbasic.R
import com.izmary.databinding.others.retrofitbasic.api.model.photo.PhotoItem
import com.izmary.databinding.others.retrofitbasic.databinding.AdapterPhotoListBinding

class PhotosAdapter(private val context: Context) :
    RecyclerView.Adapter<PhotosAdapter.ViewHolder>() {
    private val photosList = ArrayList<PhotoItem>()

    // Shimmer effect
    val shimmer = Shimmer.AlphaHighlightBuilder()// The attributes for a ShimmerDrawable is set by this builder
        .setDuration(2000) // how long the shimmering animation takes to do one full sweep
        .setBaseAlpha(0.9f) //the alpha of the underlying children
        .setHighlightAlpha(0.93f) // the shimmer alpha amount
        .setWidthRatio(1.5F)
        .setDirection(Shimmer.Direction.LEFT_TO_RIGHT)
        .setAutoStart(true)
        .build()

    val shimmerDrawable = ShimmerDrawable().apply {
        setShimmer(shimmer)
    }

    // Normal onCreate method using data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterPhotoListBinding = AdapterPhotoListBinding.inflate(inflater)
        var context = context
        return ViewHolder(binding,context)
    }

    // Set item size
    override fun getItemCount(): Int = photosList.size

    // Bind data from view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    // Remove everything from arraylist and populate the data
    fun setList(album: List<PhotoItem>) {
        photosList.clear()
        photosList.addAll(album)
    }

    // Individual data view holder
    inner class ViewHolder(val binding: AdapterPhotoListBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoItem: PhotoItem) {

            // Assign random image due the given Api does not provide a real picture
            val rnds = (200..400).random()
            val rnds2 = (200..300).random()
            val url = "https://picsum.photos/$rnds/300?random=$rnds2"
            Glide.with(context).load(url).placeholder(shimmerDrawable).error(R.drawable.noimageavailable).into(binding.imageView)
            binding.executePendingBindings()
        }
    }
}