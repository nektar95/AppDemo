package com.nektar.appdemo

import android.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Created by Aleksander on 05.05.2018.
 */
class CounterViewModelTest {
    private lateinit var viewModel: CounterViewModel

    @Rule
    @JvmField
    val instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = CounterViewModel()
    }

    @Test
    fun clickingButtonIncreasesCounter() {
        viewModel.onButtonClick()

        assertEquals(1, viewModel.counter.value)
    }
}