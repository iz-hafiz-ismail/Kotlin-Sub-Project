package com.izmary.livedataviewmodel.matchscorecounter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MatchManagerViewModel(): ViewModel() {
    //we don't encapsulate this data as two way data binding was used
    // It easier for me to just left it like that
    var team1Name = MutableLiveData<String>()
    var team2Name = MutableLiveData<String>()

    init {
        team1Name.value = "Team 1"
        team2Name.value = "Team 2"
    }


}