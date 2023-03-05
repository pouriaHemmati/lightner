package com.poudean.lightner.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

fun <T> ViewModel.setProp() = MutableLiveData<T>()
fun <T> ViewModel.getProp(obj : MutableLiveData<T>) : LiveData<T> = obj