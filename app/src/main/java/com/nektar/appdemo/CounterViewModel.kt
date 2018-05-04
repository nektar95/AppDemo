package com.nektar.appdemo

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by Aleksander on 04.05.2018.
 */
class CounterViewModel : ViewModel() {
    val counter = MutableLiveData<Int>()
    var number = 0
    fun onButtonClick() {
        counter.value = ++number
    }
}