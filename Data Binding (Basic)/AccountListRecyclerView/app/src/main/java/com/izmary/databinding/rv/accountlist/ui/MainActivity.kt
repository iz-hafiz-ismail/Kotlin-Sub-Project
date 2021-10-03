package com.izmary.databinding.rv.accountlist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.izmary.databinding.rv.accountlist.R
import com.izmary.databinding.rv.accountlist.databinding.ActivityMainBinding
import com.izmary.databinding.rv.accountlist.model.AccountData
import com.izmary.databinding.rv.accountlist.ui.adapter.RvAccountAdapter
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //initialize recycler view data (we use array list for this project)
    private var accountDataList: MutableList<AccountData> = mutableListOf<AccountData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //background level control
        binding.relativeLayoutMainMenu.background.level = 5000

        //set layout manager and adapter. accountDataList has been passed through constructor which have our account data
        binding.recyclerViewGroup.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewGroup.adapter = RvAccountAdapter(accountDataList) { selectedAccountData: AccountData ->
            accountDelete(
                selectedAccountData
            )
        }

        //add account
        binding.textViewAddAccount.setOnClickListener {
            val name = "Kediaman"
            val amount = BigDecimal("84.22")
            val number = java.util.UUID.randomUUID().toString()
            val status = "Balanced"
            accountDataList.add(AccountData(name, amount, number, status))
            binding.recyclerViewGroup.adapter!!.notifyItemInserted(accountDataList.size - 1)
        }
    }

    //remove account data
    private fun accountDelete(accountData: AccountData){
        accountDataList.remove(accountData)
        //recreate adapter as data is delete. better using notifyItemRemoved or notifyDataSetChanged but for my case,
        //it cause some issue with displaying non existing data in array list
        binding.recyclerViewGroup.adapter = RvAccountAdapter(accountDataList) { selectedAccountData: AccountData ->
            accountDelete(
                selectedAccountData
            )
        }
    }
}