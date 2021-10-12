package com.izmary.databinding.others.retrofitbasic.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.izmary.databinding.others.retrofitbasic.R
import com.izmary.databinding.others.retrofitbasic.adapter.AlbumsAdapter
import com.izmary.databinding.others.retrofitbasic.api.model.album.Albums
import com.izmary.databinding.others.retrofitbasic.api.model.photo.Photos
import com.izmary.databinding.others.retrofitbasic.api.service.AlbumService
import com.izmary.databinding.others.retrofitbasic.api.service.PhotoService
import com.izmary.databinding.others.retrofitbasic.api.service.RetrofitInstance
import com.izmary.databinding.others.retrofitbasic.databinding.ActivityDetailsBinding
import com.izmary.databinding.others.retrofitbasic.utils.Constant
import retrofit2.Response

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsBinding
    private lateinit var albumService: AlbumService
    private lateinit var photoService: PhotoService
    private lateinit var adapter: AlbumsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details)

        val userName = intent.getStringExtra(Constant.USERNAME_PARSER)

        // Set custom Action bar and it attribute
        setSupportActionBar(binding.actionBar)
        binding.actionBar.title = userName
        binding.appBarLayout.bringToFront()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        binding.lifecycleOwner = this


        // Create Service Object
        albumService = RetrofitInstance.getRetrofitInstance().create(AlbumService::class.java)
        photoService = RetrofitInstance.getRetrofitInstance().create(PhotoService::class.java)

        // Initialize Recycler VIew
        initRecyclerView()


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initRecyclerView() {
        binding.recyclerViewAlbumList.layoutManager = LinearLayoutManager(this)
        adapter = AlbumsAdapter(this)
        binding.recyclerViewAlbumList.adapter = adapter

        fetchAlbumsData()
    }

    // fetch album data and it image
    private fun fetchAlbumsData() {
        val userId = intent.getIntExtra(Constant.USERID_PARSER, -1)
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = albumService.getSortedAlbums(userId)
            emit(response)
        }

        val photosLiveData: LiveData<Response<Photos>> = liveData {
            val response = photoService.getPhotos()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumsList = it.body()
            adapter.setAlbumsList(albumsList!!)
            adapter.notifyDataSetChanged()

        })

        photosLiveData.observe(this, Observer {
            val photosList = it.body()
            adapter.setPhotosList(photosList!!)
            adapter.notifyDataSetChanged()
        })
    }

}