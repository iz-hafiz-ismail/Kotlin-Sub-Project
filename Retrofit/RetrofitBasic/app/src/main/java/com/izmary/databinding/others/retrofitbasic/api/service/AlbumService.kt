package com.izmary.databinding.others.retrofitbasic.api.service

import com.izmary.databinding.others.retrofitbasic.api.model.album.Albums
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {

    @GET("/albums")
    suspend fun getSortedAlbums(@Query(value = "userId") userId: Int): Response<Albums>
}