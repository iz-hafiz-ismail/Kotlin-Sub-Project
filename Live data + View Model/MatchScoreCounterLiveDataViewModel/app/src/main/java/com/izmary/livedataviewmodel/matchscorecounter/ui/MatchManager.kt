package com.izmary.livedataviewmodel.matchscorecounter.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.izmary.livedataviewmodel.matchscorecounter.R
import com.izmary.livedataviewmodel.matchscorecounter.databinding.ManagerMatchBinding
import com.izmary.livedataviewmodel.matchscorecounter.viewmodel.MatchManagerViewModel

//global variable to pass data
const val TEAM_NAME_PARSER1 = "com.izmary.livedataviewmodel.matchscorecounter.ui.teamname1data"
const val TEAM_NAME_PARSER2 = "com.izmary.livedataviewmodel.matchscorecounter.ui.teamname2data"

class MatchManager : AppCompatActivity() {

    private lateinit var matchManagerViewModel : MatchManagerViewModel

    //initialize view model
    private lateinit var managerMatchBinding: ManagerMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        managerMatchBinding = DataBindingUtil.setContentView(this, R.layout.manager_match)

        //view model provider
        matchManagerViewModel = ViewModelProvider(this).get(MatchManagerViewModel::class.java)

        //bind view model class.
        // e.g. bindingObject.variableNameInLayout = viewModelObject
        managerMatchBinding.managerMatchViewModelData = matchManagerViewModel
        managerMatchBinding.lifecycleOwner = this
    }

    //Intent(change activity) and send string data
    fun startMatch(view: android.view.View) {
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra(TEAM_NAME_PARSER1, matchManagerViewModel.team1Name.value!!)
            putExtra(TEAM_NAME_PARSER2, matchManagerViewModel.team2Name.value!!)
        }
        startActivity(intent)
    }
}
