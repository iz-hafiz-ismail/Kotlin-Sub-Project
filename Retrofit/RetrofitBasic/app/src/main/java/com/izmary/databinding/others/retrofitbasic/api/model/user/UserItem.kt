package com.izmary.databinding.others.retrofitbasic.api.model.user

data class UserItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)