package com.example.android_4_lesson_1.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.android_4_lesson_1.R
import com.example.android_4_lesson_1.databinding.ActivityMainBinding
import com.example.android_4_lesson_1.date.local.preferences.PreferenceHelper
import com.example.android_4_lesson_1.date.local.preferences.UserPreferencesData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData

    @Inject
    lateinit var preferenceHelper: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        setStartDestination()
    }

    private fun setStartDestination() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)

        when {
            !preferenceHelper.isAuthorize -> {
                navGraph.setStartDestination(R.id.singFlowFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.mainFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}