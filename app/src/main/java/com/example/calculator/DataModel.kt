package com.example.calculator

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel(){
    val entry: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val fragment: MutableLiveData<Fragment> by lazy {
        MutableLiveData<Fragment>()
    }

    val calcResult: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
}