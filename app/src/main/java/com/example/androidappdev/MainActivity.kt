package com.example.androidappdev

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.androidappdev.dashboard.DashboardItem
import com.example.androidappdev.data.api.RestfulApiRetrofit
import com.example.androidappdev.login.LoginFragment
import com.example.androidappdev.login.LoginRequest
import com.example.androidappdev.login.LoginResponse
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("nit3213", "onCreate: ")
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // lunch fragment use supportFragmentManager
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragment_container_view, LoginFragment::class.java, null)
            .commit()
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavBar)

        bottomNavBar.setupWithNavController(navController)

        bottomNavBar.setOnItemSelectedListener { item ->
            if (item.itemId != bottomNavBar.selectedItemId) {

                val fragmentId = when (item.itemId) {
                    R.id.navigation_dashboard -> R.id.dashboardFragment
                    R.id.navigation_details -> R.id.detailsFragment
                    else -> R.id.loginFragment
                }

                navController.popBackStack()
                navController.navigate(fragmentId)
            }
            true
        }


    }

}