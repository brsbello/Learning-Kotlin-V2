package com.example.desafio2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.desafio2.databinding.SplashScreenBinding
import com.example.desafio2.viewmodel.SplashViewModel

class SplashScreenActivity : AppCompatActivity() {

    private lateinit var splashViewModel: SplashViewModel

    private lateinit var binding: SplashScreenBinding

    private fun setSplashObservable() {
        splashViewModel.initSplashScreen()
        splashViewModel.splashLiveData.observe(this, {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        setSplashObservable()
    }

}