package com.example.desafio2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.desafio2.model.SplashModel
import kotlinx.coroutines.*

class SplashViewModel(application: Application) : AndroidViewModel(application) {

    val splashLiveData: MutableLiveData<SplashModel> = MutableLiveData()

    fun initSplashScreen() {
        viewModelScope.launch {
            delay(2000)
            updateLiveData()
        }
    }

    private fun updateLiveData() {
        splashLiveData.value = SplashModel()
    }

}