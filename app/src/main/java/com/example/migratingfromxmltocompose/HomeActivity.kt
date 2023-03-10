package com.example.migratingfromxmltocompose

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.migratingfromxmltocompose.databinding.ActivityHomeBinding
import com.example.migratingfromxmltocompose.databinding.FragmentHomeBinding

class HomeActivity : AppCompatActivity() {

    private val binding = ActivityHomeBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .add(binding.fragmentContainerView.id, HomeFragment(), "home_fragment")
            .commit()

    }
}

class HomeFragment : Fragment(){

    private val binding = FragmentHomeBinding.inflate(layoutInflater)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}
