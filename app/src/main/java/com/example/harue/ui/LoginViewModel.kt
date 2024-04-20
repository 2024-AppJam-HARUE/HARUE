package com.example.harue.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import org.jetbrains.annotations.Blocking

class LoginViewModel : ViewModel() {
    val _statuse = MutableLiveData<Boolean>()
    val statuse: LiveData<Boolean> = _statuse
}