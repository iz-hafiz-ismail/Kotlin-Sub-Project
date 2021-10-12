package com.izmary.databinding.others.retrofitbasic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.izmary.databinding.others.retrofitbasic.api.model.user.UserItem
import com.izmary.databinding.others.retrofitbasic.databinding.AdapterUserListBinding

class UserListAdapter(private val clickListener: (UserItem) -> Unit) :
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {
    private val usersList = ArrayList<UserItem>()

    // Normal onCreate method using data binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: AdapterUserListBinding = AdapterUserListBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    // Set item size
    override fun getItemCount(): Int = usersList.size

    // Bind data from view holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(usersList[position], clickListener)
    }

    // Remove everything from arraylist and populate the data
    fun setList(user: List<UserItem>) {
        usersList.clear()
        usersList.addAll(user)
    }

    // Individual data view holder
    inner class ViewHolder(val binding: AdapterUserListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(userItem: UserItem, clickListener: (UserItem) -> Unit) {
            binding.userdata = userItem
            binding.relativeLayoutUserInfo.setOnClickListener {
                clickListener(userItem)
            }
            binding.executePendingBindings()
        }
    }
}