package com.nektar.appdemo

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm = ViewModelProviders.of(this)[CounterViewModel::class.java]
        vm.counter.observe(this, Observer( {textView.text = it.toString()}))
        button.setOnClickListener {vm.onButtonClick()}
    }
}
