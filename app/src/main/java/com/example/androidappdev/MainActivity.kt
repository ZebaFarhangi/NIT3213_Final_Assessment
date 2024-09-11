package com.example.androidappdev

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

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
        /*supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.fragment_container_view, LoginPageFragment::class.java, null)
            .commit()*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        val navController = navHostFragment.navController
        val bottomNavBar = findViewById<BottomNavigationView>(R.id.bottomNavBar)

        bottomNavBar.setupWithNavController(navController)

        bottomNavBar.setOnItemSelectedListener { item ->
            if (item.itemId != bottomNavBar.selectedItemId) {

                val fragmentId = when(item.itemId) {
                    R.id.navigation_login -> R.id.loginPageFragment
                    R.id.navigation_dashboard -> R.id.dashboardFragment
                   // R.id.navigation_details -> R.id.DetailsFragment
                    else -> R.id.loginPageFragment
                }

                navController.popBackStack()
                navController.navigate(fragmentId)
            }
            true
        }


    }
    override fun onStart() {
        super.onStart()
        Log.d("nit3213", "onStart: ")
    }
    

    override fun onResume() {
        super.onResume()
        Log.d("nit3213", "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d("nit3213", "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d("nit3213", "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("nit3213", "onDestroy: ")
    }
}