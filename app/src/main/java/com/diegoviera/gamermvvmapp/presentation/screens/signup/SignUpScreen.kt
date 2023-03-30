package com.diegoviera.gamermvvmapp.presentation.screens.signup

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.diegoviera.gamermvvmapp.presentation.components.DefaultTopBar
import com.diegoviera.gamermvvmapp.presentation.screens.login.components.LoginBottomBar
import com.diegoviera.gamermvvmapp.presentation.screens.login.components.LoginContent
import com.diegoviera.gamermvvmapp.presentation.screens.signup.components.SignUpContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
                 DefaultTopBar(
                     title = "Nuevo Usuario",
                     upAvailable = true,
                     navController = navController
                 )
        },
        content = {
            SignUpContent()
        },
        bottomBar = {

        }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewSignUpScreen(){
    SignUpScreen(rememberNavController())
}