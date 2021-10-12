package com.izmary.databinding.others.retrofitbasic.api.service

import com.izmary.databinding.others.retrofitbasic.api.model.photo.Photos
import retrofit2.Response
import retrofit2.http.GET

interface PhotoService {

    @GET("/photos")
    suspend fun getPhotos(): Response<Photos>
}