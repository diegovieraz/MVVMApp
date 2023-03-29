package com.diegoviera.gamermvvmapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.diegoviera.gamermvvmapp.presentation.navigation.AppNavigation
import com.diegoviera.gamermvvmapp.presentation.screens.login.LoginScreen
import com.diegoviera.gamermvvmapp.presentation.ui.theme.GamerMVVMAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamerMVVMAppTheme(darkTheme = true) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    navController = rememberNavController()
                    AppNavigation(navController = navController)
                }
            }
        }
    }
}
