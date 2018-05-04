package com.nektar.appdemo.model

/**
 * Created by Aleksander on 05.05.2018.
 */
sealed class StateData {
    object Loading : StateData()
    object Success : StateData()
    data class Error(val throwable: Throwable) : StateData()
}