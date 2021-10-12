package com.izmary.databinding.others.retrofitbasic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.izmary.databinding.others.retrofitbasic.api.model.album.AlbumItem
import com.izmary.databinding.others.retrofitbasic.api.model.photo.PhotoItem
import com.izmary.databinding.others.retrofitbasic.databinding.AdapterAlbumsViewBinding
import kotlin.math.min

class AlbumsAdapter(private val context: Context) :
    RecyclerView.Adapter<AlbumsAdapter.ViewHolder>() {
    private lateinit var adapter: PhotosAdapter
    private val photosSortedList = ArrayList<PhotoItem>()
    private val albumsList = ArrayList<AlbumItem>()
    private val photosList = ArrayList<PhotoItem>()

    // Normal onCreate method using data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterAlbumsViewBinding = AdapterAlbumsViewBinding.inflate(inflater)
        var context = context
        return ViewHolder(binding,context)
    }

    // Set item size
    override fun getItemCount(): Int = min(albumsList.size,2)

    // Bind data from view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(albumsList[position])
    }

    // Remove everything from arraylist and populate the data
    fun setAlbumsList(album: List<AlbumItem>) {
        albumsList.clear()
        albumsList.addAll(album)
    }
    // Remove everything from arraylist and populate the data
    fun setPhotosList(photoItem: List<PhotoItem>) {
        photosList.clear()
        photosList.addAll(photoItem)
    }

    // Individual data view holder
    inner class ViewHolder(val binding: AdapterAlbumsViewBinding, context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(albumItem: AlbumItem) {
            binding.albumdata = albumItem
            binding.recyclerViewImageList.layoutManager = StaggeredGridLayoutManager(2, 1)
            adapter = PhotosAdapter(context)
            binding.recyclerViewImageList.adapter = adapter
            adapter.setList(checkPhoto(albumItem))
            adapter.notifyDataSetChanged()
            binding.executePendingBindings()
        }
    }

    // Assign photo to respective image
    private fun checkPhoto(albumItem: AlbumItem) : List<PhotoItem>{
        val photoCollection = photosList?.listIterator()
        if(photoCollection != null){
            while (photoCollection.hasNext()){
                val photoItem = photoCollection.next()
                if(albumItem.id ==photoItem.albumId){
                    photosSortedList.add(photoItem)
                }
            }
        }
        return photosSortedList
    }
}