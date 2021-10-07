package com.izmary.databinding.features.accountlistplusroom.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.izmary.databinding.features.accountlistplusroom.databinding.AdapterRvAccountBinding
import com.izmary.databinding.features.accountlistplusroom.db.Account
import java.math.BigDecimal
import java.math.RoundingMode

class RvAccountAdapter(
    private val clickListener: (Account) -> Unit
) :
    RecyclerView.Adapter<RvAccountAdapter.ViewHolder>() {

    private val accountList = ArrayList<Account>()
    val divisor = BigDecimal("100")

    // Normal onCreate method using data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterRvAccountBinding = AdapterRvAccountBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    // Set item size
    override fun getItemCount(): Int = accountList.size

    // Bind data from view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(accountList[position], clickListener)
    }

    // Remove everything from arraylist and populate the data
    fun setList(accounts: List<Account>) {
        accountList.clear()
        accountList.addAll(accounts)
    }

    // Individual data view holder
    inner class ViewHolder(val binding: AdapterRvAccountBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(account: Account, clickListener: (Account) -> Unit) {
            //convert Int data to proper output
            var amountConverter = BigDecimal(account.amount)
            amountConverter = amountConverter.divide(divisor,2, RoundingMode.HALF_EVEN)

            binding.account = account
            binding.tvTotalAmount.text = "RM " + amountConverter.toString()
            binding.linearLayoutAccountGroupAdapter.setOnClickListener {
                clickListener(account)
            }
            binding.executePendingBindings()
        }
    }
}