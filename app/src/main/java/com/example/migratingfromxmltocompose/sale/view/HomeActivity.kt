package com.example.migratingfromxmltocompose.sale.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.migratingfromxmltocompose.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainerView.id, HomeFragment(), "home_fragment")
            .commit()

    }
}