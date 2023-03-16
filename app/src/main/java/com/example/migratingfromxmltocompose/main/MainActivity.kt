package com.example.migratingfromxmltocompose.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.migratingfromxmltocompose.databinding.ActivityMainBinding
import com.example.migratingfromxmltocompose.sale.view.HomeActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            goHome()
        }

    }


    fun goHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }
}