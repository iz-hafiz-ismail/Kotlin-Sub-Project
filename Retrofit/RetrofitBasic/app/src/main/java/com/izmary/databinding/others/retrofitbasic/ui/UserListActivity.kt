package com.izmary.databinding.others.retrofitbasic.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.izmary.databinding.others.retrofitbasic.R
import com.izmary.databinding.others.retrofitbasic.adapter.UserListAdapter
import com.izmary.databinding.others.retrofitbasic.api.model.user.UserItem
import com.izmary.databinding.others.retrofitbasic.api.model.user.Users
import com.izmary.databinding.others.retrofitbasic.api.service.RetrofitInstance
import com.izmary.databinding.others.retrofitbasic.api.service.UserService
import com.izmary.databinding.others.retrofitbasic.databinding.ActivityUserListBinding
import com.izmary.databinding.others.retrofitbasic.utils.Constant
import retrofit2.Response


class UserListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserListBinding
    private lateinit var userService: UserService
    private lateinit var adapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list)
        binding.lifecycleOwner = this

        // Set custom action bar and it attribute
        setSupportActionBar(binding.actionBar)
        binding.appBarLayout.bringToFront()

        // Create Service Object
        userService = RetrofitInstance.getRetrofitInstance().create(UserService::class.java)

        // Initialize Recycler VIew
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.recyclerViewUserList.layoutManager = LinearLayoutManager(this)
        adapter =
            UserListAdapter { selectedUserData: UserItem -> listItemClicked(selectedUserData) }
        binding.recyclerViewUserList.adapter = adapter

        fetchUserData()
    }


    // Go to details layout and pass some related data
    private fun listItemClicked(userItem: UserItem) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(Constant.USERID_PARSER, userItem.id)
            putExtra(Constant.USERNAME_PARSER,userItem.username)
        }
        startActivity(intent)
    }

    // Fetch user list
    private fun fetchUserData() {
        val responseLiveData: LiveData<Response<Users>> = liveData {
            val response = userService.getUsers()
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val usersList = it.body()
            adapter.setList(usersList!!)
            adapter.notifyDataSetChanged()
        })
    }
}
