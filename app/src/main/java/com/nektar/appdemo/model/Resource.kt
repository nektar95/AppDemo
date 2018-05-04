package com.nektar.appdemo.model

/**
 * Created by Aleksander on 05.05.2018.
 */
data class Resource<out T> constructor(val status: ResourceState, val data: T?, val message: String?)
