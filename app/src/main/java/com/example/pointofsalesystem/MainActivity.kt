package com.example.pointofsalesystem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.pointofsalesystem._services.NavigationDispatcher
import com.example.pointofsalesystem.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val navController by lazy { (supportFragmentManager.findFragmentById(R.id.mainNavHost) as NavHostFragment).findNavController() }

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Navigation by fragment VMs
        navigationDispatcher.navRequests.observe(this) {
            navController.navigate(it)
        }

        // Navigation by bottom nav
        binding.mainNavBottom.setupWithNavController(navController)
    }

}