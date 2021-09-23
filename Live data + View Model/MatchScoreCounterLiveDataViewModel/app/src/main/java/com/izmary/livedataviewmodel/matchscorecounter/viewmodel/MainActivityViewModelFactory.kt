package com.izmary.livedataviewmodel.matchscorecounter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//view model factory class is all the same.just change the attribute in it for another use. It is optional to use VMFactory
class MainActivityViewModelFactory(
    private val startingScoreTeam1: Int,
    private val startingScoreTeam2: Int,
    private val startingNameTeam1: String,
    private val startingNameTeam2: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(
                startingScoreTeam1,
                startingScoreTeam2,
                startingNameTeam1,
                startingNameTeam2
            ) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }


}