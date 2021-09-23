package com.izmary.livedataviewmodel.matchscorecounter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(
    startingScoreTeam1: Int,
    startingScoreTeam2: Int,
    startingNameTeam1: String,
    startingNameTeam2: String
) : ViewModel() {

    //encapsulated teamScore data
    private var teamScore1 = MutableLiveData<Int>()
    private var teamScore2 = MutableLiveData<Int>()
    val totalTeamScore1: LiveData<Int>
        get() = teamScore1
    val totalTeamScore2: LiveData<Int>
        get() = teamScore2

    //encapsulated teamName data
    private var teamName1 = MutableLiveData<String>()
    private var teamName2 = MutableLiveData<String>()
    val dataTeamName1: LiveData<String>
        get() = teamName1
    val dataTeamName2: LiveData<String>
        get() = teamName2

    //constructor. require View Model Factory to pass data
    init {
        teamScore1.value = startingScoreTeam1
        teamScore2.value = startingScoreTeam2
        teamName1.value = startingNameTeam1
        teamName2.value = startingNameTeam2
    }

    fun scoreIncrementTeam1() {
        teamScore1.value = (teamScore1.value)?.plus(1)
    }

    fun scoreDecrementTeam1() {
        teamScore1.value = (teamScore1.value)?.minus(1)
    }

    fun scoreIncrementTeam2() {
        teamScore2.value = (teamScore2.value)?.plus(1)
    }

    fun scoreDecrementTeam2() {
        teamScore2.value = (teamScore2.value)?.minus(1)
    }

    fun scoreReset() {
        teamScore1.value = 0
        teamScore2.value = 0
    }

}