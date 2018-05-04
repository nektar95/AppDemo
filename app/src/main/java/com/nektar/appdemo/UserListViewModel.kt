package com.nektar.appdemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nektar.appdemo.model.Resource
import com.nektar.appdemo.model.ResourceState
import com.nektar.appdemo.model.StateData
import com.nektar.appdemo.model.User

/**
 * Created by Aleksander on 05.05.2018.
 */
class UserListViewModel : ViewModel() {
    val state = MutableLiveData<StateData>()
    val users = MutableLiveData<List<User>>()

    private fun loading() {
        state.value = StateData.Loading
    }

    private fun success(userList: List<User>) {
        state.value = StateData.Success
        users.value = userList
    }

    private fun error(throwable: Throwable) {
        state.value = StateData.Error(throwable)
    }
}