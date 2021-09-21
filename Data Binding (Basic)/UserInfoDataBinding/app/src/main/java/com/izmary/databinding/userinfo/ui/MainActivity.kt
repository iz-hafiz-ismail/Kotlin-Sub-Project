package com.izmary.databinding.userinfo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.izmary.databinding.userinfo.R
import com.izmary.databinding.userinfo.databinding.ActivityMainBinding
import com.izmary.databinding.userinfo.model.User

class MainActivity : AppCompatActivity() {
    //declare user data
    private val userList = listOf(
        User("Axx145643", R.drawable.rooster, "Red Dark Chick", 23),
        User("Axx534436", R.drawable.cat, "Blue Dark Cat", 32),
        User("Axx867856", R.drawable.cow, "Pink Dark Cow", 24)
    )

    // declare binding variable
    private lateinit var activityMainBinding: ActivityMainBinding

    var userItem = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set content view using binding method
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //load user data using binding method
        activityMainBinding.user = getUser()

    }

    //retrieve user data
    private fun getUser(): User {
        return userList[userItem]
    }

    //change data class (previous)
    fun previousButtonTrigger(view: android.view.View) {
        if (userItem == 0) {
            userItem = userList.size - 1
        } else {
            userItem--
        }
        activityMainBinding.user = getUser()
    }

    //change data class (next)
    fun nextButtonTrigger(view: android.view.View) {
        if (userItem == (userList.size - 1)) {
            userItem = 0
        } else {
            userItem++
        }
        activityMainBinding.user = getUser()
    }

}