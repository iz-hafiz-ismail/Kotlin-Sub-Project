package com.izmary.databinding.features.accountlistplusroom.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.izmary.databinding.features.accountlistplusroom.databinding.AdapterRvAccountBinding
import com.izmary.databinding.features.accountlistplusroom.db.Account

class RvAccountAdapter(
    private val accountList: List<Account>,
    private val clickListener: (Account) -> Unit
) :
    RecyclerView.Adapter<RvAccountAdapter.ViewHolder>() {
    private lateinit var binding: AdapterRvAccountBinding

    // Normal oncreate method using data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = AdapterRvAccountBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    // Set item size
    override fun getItemCount(): Int = accountList.size

    // Bind data from view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(accountList[position], clickListener)
    }

    // Individual data view holder
    inner class ViewHolder(binding: AdapterRvAccountBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(account: Account, clickListener: (Account) -> Unit) {
            binding.account = account
            binding.linearLayoutAccountGroupAdapter.setOnClickListener {
                clickListener(account)
            }
            binding.executePendingBindings()
        }
    }
}