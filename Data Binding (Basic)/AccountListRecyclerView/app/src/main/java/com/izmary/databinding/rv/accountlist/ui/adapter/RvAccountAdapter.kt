package com.izmary.databinding.rv.accountlist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.izmary.databinding.rv.accountlist.databinding.AdapterRvAccountBinding
import com.izmary.databinding.rv.accountlist.model.AccountData

class RvAccountAdapter(private val accountDataList: List<AccountData>, private val clickListener: (AccountData)->Unit) :
    RecyclerView.Adapter<RvAccountAdapter.ViewHolder>() {
    private lateinit var binding: AdapterRvAccountBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = AdapterRvAccountBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    //set item size
    override fun getItemCount(): Int = accountDataList.size

    //bind data form view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(accountDataList[position],clickListener)
    }

    //avoid from item in recycler view switching when scrolling but effect performance as it kind of disable recycle stuff. But we use it for this
    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(binding: AdapterRvAccountBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(accountData: AccountData, clickListener: (AccountData)->Unit) {
            /* binding.nameSetInLayout = dataType
               binding.executePendingBindings()  */
            binding.accountData = accountData
            binding.linearLayoutAccountGroupAdapter.setOnClickListener{
                clickListener(accountData)
            }
            binding.executePendingBindings()
        }
    }
}