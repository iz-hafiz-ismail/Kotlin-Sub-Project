package com.izmary.databinding.features.accountlistplusroom.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.izmary.databinding.features.accountlistplusroom.R
import com.izmary.databinding.features.accountlistplusroom.databinding.ActivityMainBinding
import com.izmary.databinding.features.accountlistplusroom.db.Account
import com.izmary.databinding.features.accountlistplusroom.db.AccountDatabase
import com.izmary.databinding.features.accountlistplusroom.db.AccountRepository
import com.izmary.databinding.features.accountlistplusroom.ui.adapter.RvAccountAdapter
import com.izmary.databinding.features.accountlistplusroom.viewmodel.MainActivityViewModel
import com.izmary.databinding.features.accountlistplusroom.viewmodel.MainActivityViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mainActivityViewModel: MainActivityViewModel
    private lateinit var mainActivityViewModelFactory: MainActivityViewModelFactory
    private lateinit var adapter: RvAccountAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Background level control
        binding.relativeLayoutMainMenu.background.level = 5000

        // Initialize view model and view model factory
        val dao = AccountDatabase.getInstance(application).uAccountDAO
        val repository = AccountRepository(dao)
        mainActivityViewModelFactory = MainActivityViewModelFactory(repository)
        mainActivityViewModel = ViewModelProvider(
            this,
            mainActivityViewModelFactory
        ).get(MainActivityViewModel::class.java)
        binding.mainActivityViewModelData = mainActivityViewModel
        binding.lifecycleOwner = this

        initRecyclerView()

        // Toast Message if you want to use it. You can change message inside view model class
        mainActivityViewModel.message.observe(this, Observer {
            it.getContentIfNotHandled()?.let {
//                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun initRecyclerView() {
        // Initialize Recycler view
        binding.recyclerViewGroup.layoutManager = LinearLayoutManager(this)
        adapter = RvAccountAdapter { selectedAccountData: Account ->
            listItemClicked(selectedAccountData)
        }
        binding.recyclerViewGroup.adapter =adapter

        // Automatically update data as we use Live Data. No need for manual assign data
        mainActivityViewModel.getSaveUAccounts().observe(this, Observer {
            adapter.setList(it)
            adapter.notifyDataSetChanged()

        })
    }

    // Select an account
    private fun listItemClicked(account: Account) {
        mainActivityViewModel.initUpdateAndDelete(account)
    }
}