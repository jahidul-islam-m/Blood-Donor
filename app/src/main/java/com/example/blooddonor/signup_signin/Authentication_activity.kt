package com.example.blooddonor.signup_signin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blooddonor.R
import com.example.blooddonor.databinding.ActivityAuthenticationBinding

class Authentication_activity : AppCompatActivity() {

    private lateinit var binding:ActivityAuthenticationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}