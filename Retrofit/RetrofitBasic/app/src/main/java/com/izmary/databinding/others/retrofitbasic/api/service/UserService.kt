package com.izmary.databinding.others.retrofitbasic.api.service

import com.izmary.databinding.others.retrofitbasic.api.model.user.Users
import retrofit2.Response
import retrofit2.http.GET

interface UserService {

    @GET("/users")
    suspend fun getUsers(): Response<Users>


}