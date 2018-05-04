package com.nektar.appdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.nektar.appdemo.R.id.recyclerView
import com.nektar.appdemo.R.id.swipeRefreshLayout
import com.nektar.appdemo.model.StateData
import com.nektar.appdemo.model.User


class MainActivity : AppCompatActivity() {

    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

       // recyclerView.adapter = adapter

        val vm = ViewModelProviders.of(this)[UserListViewModel::class.java]
        vm.state.observe(this, Observer({ updateState(it) }))
        vm.users.observe(this, Observer({ updateData(it) }))

       // swipeRefreshLayout.setOnRefreshListener { vm.getUsers(refresh = true) }
    }

    private fun updateState(stateData: StateData?) {

    }

    private fun updateData(userList: List<User>?) {
        userList?.let {
            adapter.addItems(userList)
        }
    }
}
