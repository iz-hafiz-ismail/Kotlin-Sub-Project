package com.izmary.livedataviewmodel.matchscorecounter.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.izmary.livedataviewmodel.matchscorecounter.R
import com.izmary.livedataviewmodel.matchscorecounter.databinding.ActivityMainBinding
import com.izmary.livedataviewmodel.matchscorecounter.viewmodel.MainActivityViewModel
import com.izmary.livedataviewmodel.matchscorecounter.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    //initialize view model and view model factory class
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //retrieve team name data from intent
        val dataTeam1Name = intent.getStringExtra(TEAM_NAME_PARSER1)
        val dataTeam2Name = intent.getStringExtra(TEAM_NAME_PARSER2)

        //initial data to pass for our view model
        //optional: if you want to set variable through constructor
        mainActivityViewModelFactory = MainActivityViewModelFactory(0, 0, dataTeam1Name!!, dataTeam2Name!!)

        //view model provider.If you don't have view model factory, you can just left it blank
        // e.g. ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel = ViewModelProvider(this, mainActivityViewModelFactory).get(MainActivityViewModel::class.java)

        //bind view model class.
        // e.g. bindingObject.variableNameInLayout = viewModelObject
        activityMainBinding.mainActivityViewModelData = mainActivityViewModel
        activityMainBinding.lifecycleOwner = this
    }
}