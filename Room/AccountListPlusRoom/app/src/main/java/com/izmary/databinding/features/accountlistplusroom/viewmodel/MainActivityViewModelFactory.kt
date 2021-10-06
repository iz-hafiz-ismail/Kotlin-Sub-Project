package com.izmary.databinding.features.accountlistplusroom.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.izmary.databinding.features.accountlistplusroom.db.AccountRepository
import java.lang.IllegalArgumentException

// Boilerplate code. just passing repository argument for view model constructor
class MainActivityViewModelFactory(private val repository: AccountRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}